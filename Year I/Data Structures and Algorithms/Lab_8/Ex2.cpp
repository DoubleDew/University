#include <iostream>
#include <bits/stdc++.h>
using namespace std;

void addedge(list<int>* g, int u, int v)
{
    g[u].push_back(v);
    g[v].push_back(u);
}

int hamiltonian(list<int>* g, int v, int s, int& count, bool* vis, int& h)
{
    if (count > 1 && s == 0) 
    {
        h = 1;
        return 1;
    }
    list<int>::iterator it;
    for (it = g[s].begin(); it != g[s].end(); it++) 
    {
        if (!vis[*it])
        {
            vis[*it] = true;
            count++;
            if (count == v)
                vis[0] = false;
            hamiltonian(g, v, *it, count, vis, h);
            vis[0] = true;
            vis[*it] = false;
            count--;
        }
    }
    return 0;
}

int main()
{
    int num;
    cin >> num;
    for (int i = 0; i < num; i++) 
    {
        int v, e;
        cin >> v >> e;
        list<int> g[v];
        int x, y;
        for (int j = 0; j < e; j++) 
        {
            cin >> x >> y;
            addedge(g, x, y);
        }
        bool vis[v];
        memset(vis, false, sizeof(vis));
        int count = 1;
        vis[0] = true;
        int h = 0;
        hamiltonian(g, v, 0, count, vis, h);
        cout << h << endl;
    }
    return 0;
}