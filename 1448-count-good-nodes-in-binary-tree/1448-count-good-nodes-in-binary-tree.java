class Solution {
    public int goodNodes(TreeNode root) {
        return solve(root, Integer.MIN_VALUE);
    }

    private int solve(TreeNode node, int maxNode) {
        if (node == null) {
            return 0;
        }

        int count = 0;
        if (node.val >= maxNode) {
            count = 1;
        }
        maxNode = Math.max(maxNode, node.val);
        count += solve(node.left, maxNode);
        count += solve(node.right, maxNode);

        return count;
    }
}