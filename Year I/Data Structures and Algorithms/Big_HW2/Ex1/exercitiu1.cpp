#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <fstream>
#include <cmath>
using namespace std;

struct node
{
    int val;
    struct node *next;
};

struct node *add(struct node *head, int num)
{
    struct node *p = (struct node *)malloc(sizeof(struct node));

    p->val = num;
    p->next = head;

    return p;
}

void breadth_first_search(struct node *list[], int vertices, int parent[], int level[])
{
    struct node *temp;
    int i, par, lev, flag = 1;

    lev = 0;
    level[1] = lev;

    while (flag)
    {
        flag = 0;
        for (i = 1; i <= vertices; ++i)
        {
            if (level[i] == lev)
            {
                flag = 1;
                temp = list[i];
                par = i;

                while (temp != NULL)
                {
                    if (level[temp->val] != -1)
                    {
                        temp = temp->next;
                        continue;
                    }

                    level[temp->val] = lev + 1;
                    parent[temp->val] = par;
                    temp = temp->next;
                }
            }
        }

        ++lev;
    }
}

void replace(struct node *head, int num, int replaced_num)
{
    struct node *p = head;

    while (p->next != NULL)
    {
        if (p->val == num)
        {
            break;
        }

        p = p->next;
    }

    p->val = replaced_num;
}

int main()
{
    int vertices, edges, i, j, v1, v2;
    vertices = 100; // For a 10X10 board
    edges = 0;      // Just to count the edges
    int num_ladders;
    int num_snakes;

    struct node *list[vertices + 1];

    int parent[vertices + 1];
    int level[vertices + 1];

    for (i = 0; i <= vertices; ++i)
    {
        // Initialising our arrays
        list[i] = NULL;
        parent[i] = 0;
        level[i] = -1;
    }

    for (i = 1; i <= vertices; ++i)
    {
        for (j = 1; j <= 6 && j + i <= 100; ++j)
        {
            list[i] = add(list[i], i + j);
            ++edges;
        }
    }

    cin>>num_ladders>>num_snakes;
    pair<int, int> ladders[num_ladders];
    pair<int, int> snakes[num_snakes];
    for (i = 0; i < num_ladders; ++i)
    {
        cin >> v1 >> v2;
        ladders[i].first = v1;
        ladders[i].second = v2;
        j = v1 - 6;

        if (j < 1)
        {
            j = 1;
        }

        for (j; j < v1; ++j)
        {
            replace(list[j], v1, v2);
        }
    }

    for (i = 0; i < num_snakes; ++i)
    {
        cin >> v1 >> v2;
        j = v1 - 6;
        snakes[i].first = v1;
        snakes[i].second = v2;
        if (j < 0)
        {
            j = 0;
        }

        for (j; j < v1; ++j)
        {
            // Replacing Vertex value v1 by v2
            replace(list[j], v1, v2);
        }
    }

    breadth_first_search(list, vertices, parent, level);
    printf("\nNumber of Moves required = %d\n", level[vertices]);

    /*Just a little mechanism to print the shortest path*/
    int path[level[vertices] + 1];

    for (int i = 0; i < num_ladders; i++)
    {
        parent[ladders[i].second] = ladders[i].first;
        parent[ladders[i].first] = parent[ladders[i].first - 1];
    }

    j = 100;

    path[0] = j;
    // TODO - sa se retina valorile intr-un vector si sa fie afisate invers
    int diceThrow[vertices], throws = 0;
    for (i = 0; i <= level[vertices]; ++i)
    {
        if (fabs(j - parent[j]) <= 6)
            diceThrow[throws++] = fabs(j - parent[j]);
        path[i] = parent[j];
        j = parent[j];
    }
    diceThrow[throws++] = j - parent[j];

    cout << "Valorile obtinute la aruncarea zarurilor:\n";
    for (int i = throws - 1; i >= 0; i--)
        cout << diceThrow[i] << ' ';
    return 0;
}
