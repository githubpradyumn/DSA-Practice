class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length+1];
        Arrays.fill(dp,-1);
        return Math.min(solution(cost,0),solution(cost,1));
   }
   public int solution(int[] cost, int n){
        if(n>=cost.length) return 0;
        // if(n==0||n==1) return cost[n];
        if(dp[n]!=-1) return dp[n];
        return dp[n] = cost[n] + Math.min(solution(cost,n+1),solution(cost,n+2));
   }
}