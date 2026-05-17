/*class Node
{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}*/

// function should return the count of total number of non leaf nodes in the tree.
class Solution {
    int total = 0;
    int count = 0;
    int countNonLeafNodes(Node root) {
        // code here
        leaves(root);
        totalLeaves(root);
        return total-count;
    }
    void leaves(Node root){
        if(root==null) return;
        if(root.left==null && root.right==null){
            count++;
            return;
        }
        leaves(root.left);
        leaves(root.right);
    }
    void totalLeaves(Node root){
        if(root==null) return;
        total++;
        totalLeaves(root.left);
        totalLeaves(root.right);
    }
}