class Solution {
    static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return solve(arr, dp, 1, n - 1);
    }

    static int solve(int[] arr, int[][] dp, int i, int j) {
        if (i == j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;
        
        for (int k = i; k < j; k++) {
            int left = solve(arr, dp, i, k);
            int right = solve(arr, dp, k + 1, j);
            int cost = left + right + (arr[i - 1] * arr[k] * arr[j]);

            min = Math.min(min, cost);
        }

        return dp[i][j] = min;
    }
}