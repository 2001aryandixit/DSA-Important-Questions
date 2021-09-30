import java.util.ArrayDeque;
import java.util.Queue;
 
// A class to store a binary tree node
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}
 
class Main
{
    // Function to perform preorder traversal on a given binary tree
    public static void preorder(Node root)
    {
        if (root == null) {
            return;
        }
 
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
 
    // Utility function to swap left subtree with right subtree
    public static void swap(Node root)
    {
        if (root == null) {
            return;
        }
 
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
 
    // Iterative function to invert a given binary tree using a queue
    public static void invertBinaryTree(Node root)
    {
        // base case: if the tree is empty
        if (root == null) {
            return;
        }
 
        // maintain a queue and push the root node
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
 
        // loop till queue is empty
        while (!q.isEmpty())
        {
            // dequeue front node
            Node curr = q.poll();
 
            // swap the left child with the right child
            swap(curr);
 
            // enqueue left child of the popped node
            if (curr.left != null) {
                q.add(curr.left);
            }
 
            // enqueue right child of the popped node
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
    }
 
    public static void main(String[] args)
    {
        /* Construct the following tree
                  1
                /   \
               /     \
              2       3
             / \     / \
            4   5   6   7
        */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
 
        invertBinaryTree(root);
        preorder(root);
    }
}
