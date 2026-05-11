class Solution {
    public int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n = val.length;
        int[][] dp = new int[n+1][capacity+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return helper(val, wt, capacity, n, dp);
    }
    // public int helper(int val[], int wt[], int capacity, int n){
    //     if(n==0) return 0;
    //     if(capacity==0) return 0;  
    //     int notPick = helper(val,wt,capacity,n-1);
    //     int pick = 0;
    //     if(wt[n-1]<=capacity){
    //         pick = val[n-1] + helper(val,wt,capacity-wt[n-1],n);
    //     }
    //     return Math.max(pick,notPick);
    // }
    public int helper(int val[], int wt[], int capacity, int n, int[][] dp){
        if(n==0) return 0;
        if(capacity==0) return 0;  
        if(dp[n][capacity]!=-1) return dp[n][capacity];
        int notPick = helper(val,wt,capacity,n-1,dp);
        int pick = 0;
        if(wt[n-1]<=capacity){
            pick = val[n-1] + helper(val,wt,capacity-wt[n-1],n,dp);
        }
        return dp[n][capacity]=  Math.max(pick,notPick);
    }
}