class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return Math.min(solution(cost,n-1),solution(cost,n-2));
   }
   public int solution(int[] cost, int n){
        if(n<0) return 0;
        if(n==0||n==1) return cost[n];
        if(dp[n]!=-1) return dp[n];
        return dp[n] = cost[n] + Math.min(solution(cost,n-2),solution(cost,n-1));
   }
}