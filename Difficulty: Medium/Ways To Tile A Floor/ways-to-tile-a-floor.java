class Solution {
    public int numberOfWays(int n) {
        // code here
        int[]  dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n,dp);
    }
    
    public int helper(int n, int[] dp){
        if(n<0) return 0;
        if(n==0) return 1; 
        if(dp[n]!=-1) return dp[n];
        int notTake = helper(n-1,dp);
        int take = helper(n-2,dp);
        return dp[n] = take + notTake;
    }
    
}