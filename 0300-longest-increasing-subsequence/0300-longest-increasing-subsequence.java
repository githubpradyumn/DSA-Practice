class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return helper(nums,0,-1,dp);
    }
    public int helper(int[] nums, int idx, int preidx,int[][] dp){
        if(idx==nums.length) return 0;
        if(dp[idx][preidx+1]!=-1) return dp[idx][preidx+1];
        int notTake = helper(nums,idx+1,preidx,dp);
        int take = 0;
        if(preidx==-1 || nums[idx]>nums[preidx]){
            take = 1 + helper(nums,idx+1,idx,dp);
        }
        return dp[idx][preidx+1] = Math.max(take,notTake);
    }
}