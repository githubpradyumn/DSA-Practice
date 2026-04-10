// User function Template for Java
class Solution {
    // code here
    Integer[][] dp;

    public int maximumPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        dp = new Integer[n][m];
        int minSum = Integer.MIN_VALUE;

        for (int col = 0; col < m; col++) {
            minSum = Math.max(minSum, findMinValue(matrix, 0, col));
        }
        return minSum;
    }

    public int findMinValue(int[][] matrix, int row, int col) {
        if (col < 0 || col >= matrix[0].length) return Integer.MIN_VALUE;

        if (row == matrix.length - 1) return matrix[row][col];

        if (dp[row][col] != null) return dp[row][col];

        int left = findMinValue(matrix, row + 1, col - 1);
        int down = findMinValue(matrix, row + 1, col);
        int right = findMinValue(matrix, row + 1, col + 1);
        
        int next = Math.max(left, right); 
        int minNext = Math.max(down, next);
        dp[row][col] = matrix[row][col] + minNext;

        return dp[row][col];
    }
}