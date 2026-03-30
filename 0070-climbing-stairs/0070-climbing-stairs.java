class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solution(n);
    }
    public int solution(int n){
        if(n<2) return 1;
        if(dp[n]!=-1) return dp[n];
        return dp[n] = solution(n-1) + solution(n-2);
    }
}