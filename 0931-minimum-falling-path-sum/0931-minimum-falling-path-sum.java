class Solution {
    Integer[][] dp;

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        dp = new Integer[n][n];
        int minSum = Integer.MAX_VALUE;

        for (int col = 0; col < n; col++) {
            minSum = Math.min(minSum, findMinValue(matrix, 0, col));
        }
        return minSum;
    }

    public int findMinValue(int[][] matrix, int row, int col) {
        if (col < 0 || col >= matrix.length) return Integer.MAX_VALUE;

        if (row == matrix.length - 1) return matrix[row][col];

        if (dp[row][col] != null) return dp[row][col];

        int left = findMinValue(matrix, row + 1, col - 1);
        int down = findMinValue(matrix, row + 1, col);
        int right = findMinValue(matrix, row + 1, col + 1);
        
        int next = Math.min(left, right); 
        int minNext = Math.min(down, next);
        dp[row][col] = matrix[row][col] + minNext;

        return dp[row][col];
    }
}