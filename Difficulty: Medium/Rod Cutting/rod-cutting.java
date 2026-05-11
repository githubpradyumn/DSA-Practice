class Solution {
    public int cutRod(int[] price) {
        // code here
        int n = price.length;
        int i = 0;
        int[][] dp = new int[n+1][n+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return helper(price, n, i,dp);
    }
    
    public int helper(int[] price, int n , int i, int[][]dp){
        
        if(n==0) return 0;
        
        if(i>=price.length) return 0;
        
        if(dp[n][i]!=-1) return dp[n][i];
        
        int length = i+1;
        int take = Integer.MIN_VALUE;
        
        if(length<=n){
            take = price[i] + helper(price,n-length,i,dp);
        }
        
        int notTake = helper(price,n,i+1,dp);
        
        return dp[n][i] = Math.max(take,notTake);
    }
}