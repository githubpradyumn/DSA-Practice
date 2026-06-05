import java.util.*;

class Solution {
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;

        int max = Integer.MIN_VALUE;
        int ansLevel = 1;
        int currLevel = 1;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            int levelSum = 0;

            while (size > 0) {
                TreeNode curr = q.remove();
                levelSum += curr.val;

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
                size--;
            }

            if (levelSum > max) {
                max = levelSum;
                ansLevel = currLevel;
            }

            currLevel++;
        }

        return ansLevel;
    }
}