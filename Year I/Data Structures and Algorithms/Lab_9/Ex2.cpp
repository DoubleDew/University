#include <iostream>
#include <list>
#include <stdio.h>
#include <string.h>
#include <ctype.h>

using namespace std;

struct node
{
	int data;
	int count;
	node *left;
	node *right;
};

node* CreateNode(int data)
{
	node *newnode = new node;
	newnode->data = data;
	newnode->count = 1;
	newnode->left = NULL;
	newnode->right = NULL;

	return newnode;
}

node* InsertIntoTree(node* root, int data)
{
	node *temp = CreateNode(data);
	node *t = new node;
	t = root;

	if(root == NULL)
		root = temp;
	else
	{
		while(t != NULL)
		{
			if(t->data == data)
			{
				t->count++;
				break;
			}
			else if(t->data < data )
			{
				if(t->right == NULL)
				{
					t->right = temp;
					break;
				}
				t = t->right;
			}
			else if(t->data > data)
			{
				if(t->left == NULL)
				{
					t->left = temp;
					break;
				}
				t = t->left;
			}
		}
	}
	return root;
}

void Search(node *root, int data)
{
	node *temp = new node;
	temp = root;

	while(temp != NULL)
	{
		if(temp->data == data)
		{
			cout<<"\n The number "<<data<<" was found "<<temp->count<<" times.";
			return;
		}
		else if(temp->data > data)
			temp = temp->left;
		else
			temp = temp->right;
	}

	cout<<"\n Not found";
	return;
}


int main()
{
	char ch;
	int n, i, a[25] = {89, 53, 95, 1, 9, 67, 72, 66, 75, 89, 72, 89, 89, 53, 77, 18, 24, 35, 90, 38, 90, 49, 81, 27, 97};
	node *root = new node;
	root = NULL;

	// Construct the BST.
	for(i = 0; i < 25; i++)
		root = InsertIntoTree(root, a[i]);

	up:
	cout<<"\nEnter the Element to be searched: ";
	cin>>n;

	Search(root, n);

	return 0;
}