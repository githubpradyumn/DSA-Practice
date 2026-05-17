/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}
*/

class Solution {
    // static int sum = 0;
    static int sumBT(Node root) {
        if(root == null) return 0;
        return root.data + sumBT(root.left) + sumBT(root.right);
        // code here
        // totalSum(root);
        // return sum;
    }
    // static void totalSum(Node root){
    //     if(root==null) return;
    //     sum += root.data;
    //     totalSum(root.left);
    //     totalSum(root.right);
    // }
}