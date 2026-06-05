/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int findBottomLeftValue(TreeNode root) {

        if(root == null) return 0;
        int leftMostNode = root.val;;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();

            while(size != 0){
                TreeNode curr = q.remove();
                leftMostNode = curr.val;
                list.add(curr.val);
                if(curr.right != null){
                    q.add(curr.right);
                }
                if(curr.left != null){
                    q.add(curr.left);
                }
                size--;

            }
        }
        return leftMostNode;
    }
}