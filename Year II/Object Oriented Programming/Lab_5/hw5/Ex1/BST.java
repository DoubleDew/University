package Ex1;

class Node
{
    int key;
    Node left, right;

    public Node(int data)
    {
        this.key = data;
        this.left = this.right = null;
    }
}

class BST
{
    Node root;

    public BST()
    {
        this.root = null;
    }

    void insert(int key)
    {
        root = insert_recursive(root, key);
    }

    Node insert_recursive(Node root, int key)
    {
        if(root == null)
        {
            root = new Node(key);
            return root;
        }

        if(key < root.key) 
            root.left = insert_recursive(root.left, key);
        else 
            if(key > root.key) 
                root.right = insert_recursive(root.right, key);
        return root;
    }

    boolean find(int key)
    {
        root = search_recursive(root, key);
        if(root != null) 
            return true;
        else 
            return false;
    }

    Node search_recursive(Node root, int key)
    {
        if(root == null || root.key == key) 
            return root;
        if(root.key < key) 
            return search_recursive(root.right, key);
        return search_recursive(root.left, key);
    }

    void display()
    {
        display_recursive(root);
    }

    void display_recursive(Node root)
    {
        if(root != null)
        {
            display_recursive(root.left);
            System.out.println(root.key + " ");
            display_recursive(root.right);
        }
    }
}