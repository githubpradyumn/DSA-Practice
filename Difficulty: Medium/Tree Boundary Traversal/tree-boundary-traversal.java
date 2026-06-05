import java.util.ArrayList;
import java.util.Collections;

class Solution {
    
    private boolean isLeaf(Node node) {
        return (node != null && node.left == null && node.right == null);
    }

    ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;

        if (!isLeaf(root)) {
            list.add(root.data);
        }

        leftFunc(root.left, list);

        leaf(root, list);

        ArrayList<Integer> right = new ArrayList<>();
        rightFunc(root.right, right);
        Collections.reverse(right);
        list.addAll(right);

        return list;
    }

    void leftFunc(Node node, ArrayList<Integer> list) {
        if (node == null || isLeaf(node)) return;

        list.add(node.data);
        
        if (node.left != null) {
            leftFunc(node.left, list);
        } else {
            leftFunc(node.right, list);
        }
    }
    void leaf(Node node, ArrayList<Integer> list) {
        if (node == null) return;

        if (isLeaf(node)) {
            list.add(node.data);
            return;
        }

        leaf(node.left, list);
        leaf(node.right, list);
    }

    void rightFunc(Node node, ArrayList<Integer> rightList) {
        if (node == null || isLeaf(node)) return;

        rightList.add(node.data);
        if (node.right != null) {
            rightFunc(node.right, rightList);
        } else {
            rightFunc(node.left, rightList);
        }
    }
}