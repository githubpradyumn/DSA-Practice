class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n+1][amount+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return helper(amount,coins,n,dp);
    }
    public int helper(int amount, int[] coins, int n,int[][] dp){
        if(amount==0) return 1;
        if(n==0 || amount<0) return 0;
        if(dp[n][amount]!=-1) return dp[n][amount];
        int notPick = helper(amount,coins,n-1,dp); 
        int pick = helper(amount-coins[n-1],coins,n,dp);
        return dp[n][amount] = pick+notPick;
    }
}