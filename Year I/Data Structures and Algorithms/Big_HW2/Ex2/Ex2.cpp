#include <bits/stdc++.h>
using namespace std;

struct NODE
{
    int value;
    NODE *right;
    NODE *left;

    NODE(int data)
    {
        this->value = data;
        this->right = NULL;
        this->left = NULL;
    }
};

struct Tree
{
    int maxValue;
    int minValue;
    bool isBST;
    int sum;
    int currentMaximum;
};

Tree maxSumBST(struct NODE *root, int &maxSum)
{
    if (root == NULL)
    {
        Tree tmp;
        tmp.minValue = INT_MAX;
        tmp.maxValue = INT_MIN;
        tmp.isBST = true;
        tmp.sum = 0;
        tmp.currentMaximum = 0;
        return tmp;
    }

    if (root->left == NULL && root->right == NULL)
    {
        maxSum = max(maxSum, root->value);
        Tree tmp;
        tmp.maxValue = root->value;
        tmp.minValue = root->value;
        tmp.isBST = true;
        tmp.sum = root->value;
        tmp.currentMaximum = maxSum;
        return tmp;
    }

    Tree left = maxSumBST(root->left, maxSum);

    Tree right = maxSumBST(root->right, maxSum);

    Tree tree;

    if (left.isBST == true && right.isBST == true && left.maxValue < root->value && right.minValue > root->value)
    {
        tree.maxValue = max(root->value, max(left.maxValue, right.maxValue));

        tree.minValue = min(root->value, min(left.minValue, right.minValue));

        maxSum = max(maxSum, right.sum + root->value + left.sum);

        tree.currentMaximum = maxSum;
        tree.isBST = true;
        return tree;
    }

    tree.isBST = false;
    tree.currentMaximum = maxSum;
    tree.sum = right.sum + left.sum + root->value;
    return tree;
}

int maxSum(struct NODE *root)
{
    int maxValue = INT_MIN;
    return maxSumBST(root, maxValue).currentMaximum;
}

int main()
{
    struct NODE *root = new NODE(5);
    root->left = new NODE(14);
    root->right = new NODE(3);
    root->left->left = new NODE(6);
    root->right->right = new NODE(7);
    root->left->left->left = new NODE(9);
    root->left->left->right = new NODE(1);

    cout << maxSum(root);

    return 0;
}
