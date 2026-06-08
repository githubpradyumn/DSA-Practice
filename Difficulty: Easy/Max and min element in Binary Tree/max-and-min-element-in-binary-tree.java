class Solution {
    static int minValue;
    static int maxValue;

    public static int findMax(Node root) {
        if (root == null) return Integer.MIN_VALUE;
        minValue = Integer.MAX_VALUE;
        maxValue = Integer.MIN_VALUE;
        
        solve(root); 
        return maxValue;
    }

    public static int findMin(Node root) {
        if (root == null) return Integer.MAX_VALUE;
        minValue = Integer.MAX_VALUE;
        maxValue = Integer.MIN_VALUE;
        
        solve(root); 
        return minValue; 
    }

    public static void solve(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Node curr = q.remove();
                
                if (curr.data < minValue) {
                    minValue = curr.data;
                }
                if (curr.data > maxValue) {
                    maxValue = curr.data;
                }

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }
}