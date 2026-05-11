class Solution {
    public int coinChange(int[] coins, int amount){
        int n =  coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int i=1; i<=amount; i++){
            dp[0][i] = (int)1e9;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=amount;j++){
                int notPick = dp[i-1][j];
                int pick = (int)1e9; 
                if (coins[i - 1] <= j) {
                    pick = 1 + dp[i][j - coins[i - 1]];
                }
                dp[i][j] = Math.min(pick,notPick);
            }
        }
        return dp[n][amount]==(int)1e9 ? -1 : dp[n][amount];

    }  
     
    // public int coinChange(int[] coins, int amount) {
    //     int n =  coins.length;
    //     int[][] dp = new int[n+1][amount+1];
    //     for(int[] row : dp){
    //         Arrays.fill(row,-1);
    //     }
    //     dp[n][amount]= helper(coins,amount,n,dp);
    //     return dp[n][amount] == (int)1e9 ? -1 : dp[n][amount];
    // }
    // public int helper(int[] coins, int amount, int n, int[][] dp){
    //     if(amount==0) return 0;
    //     if(n==0 || amount<0) return (int)1e9;
    //     if(dp[n][amount]!=-1) return dp[n][amount];
    //     int notPick = helper(coins,amount,n-1,dp); 
    //     int pick = 1 + helper(coins,amount-coins[n-1],n,dp);
    //     return dp[n][amount] = Math.min(notPick,pick);
    // }
}
