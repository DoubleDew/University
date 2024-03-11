#include <iostream>
#include <list>
#include <stdio.h>
#include <string.h>
#include <ctype.h>

using namespace std;

// A structure representing a node of a tree.
struct node
{
	int data;
	int count;
	node *left;
	node *right;
};

// A function creating a new node of the tree and assigning the data.
node* CreateNode(int data)
{
	node *newnode = new node;
	newnode->data = data;
	newnode->count = 1;
	newnode->left = NULL;
	newnode->right = NULL;

	return newnode;
}

// A function creating binary search tree.
node* InsertIntoTree(node* root, int data)
{
	// Create node using data from argument list.
	node *temp = CreateNode(data);
	node *t = new node;
	t = root;

	// If root is null, assign it to the node created.
	if(root == NULL)
		root = temp;
	else
	{
		// Find the position for the new node to be inserted.
		while(t != NULL)
		{
			// If the new data is already there then just increase the counter.
			if(t->data == data)
			{
				t->count++;
				break;
			}
			else if(t->data < data )
			{
				if(t->right == NULL)
				{
					// If current node is NULL then insert the node.
					t->right = temp;
					break;
				}
				// Shift pointer to the left.
				t = t->right;
			}
			else if(t->data > data)
			{
				if(t->left == NULL)
				{
					// If current node is NULL then insert the node.
					t->left = temp;
					break;
				}
				// Shift pointer to the left.
				t = t->left;
			}
		}
	}
	return root;
}

// A function to search item in a BST.
void Search(node *root, int data)
{
	node *temp = new node;
	temp = root;
	// Run the loop until temp points to a NULL pointer or data element is found.
	while(temp != NULL)
	{
		if(temp->data == data)
		{
			cout<<"\n The number "<<data<<" was found "<<temp->count<<" times.";
			return;
		}
		// Shift pointer to left child.
		else if(temp->data > data)
			temp = temp->left;
		// Shift pointer to right child.
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
