class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) {
                dp[0][i] = i / coins[0];
            } else {
                dp[0][i] = Integer.MAX_VALUE-1; 
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                int nottake = dp[i - 1][j];
                int take = Integer.MAX_VALUE-1;
                if (coins[i] <= j) {
                    take = 1 + dp[i][j - coins[i]];
                }
                dp[i][j] = Math.min(take, nottake);
            }
        }

        int ans = dp[n - 1][amount];
        return (ans >= Integer.MAX_VALUE-1) ? -1 : ans;
    }
}