class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        // code here
        int n = nums.length;
        int[][] dp = new int[n+1][target+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return helper(nums,target,n,dp);
    }
    public int helper(int[] nums, int target, int n, int[][] dp) {
        if (n == 0) {
            return (target == 0) ? 1 : 0;
        }   
        
        if(dp[n][target]!=-1) return dp[n][target];

        int notTake = helper(nums, target, n - 1,dp);

        int take = 0;

        if (target >= nums[n - 1]) {
            take = helper(nums, target - nums[n - 1], n - 1,dp);
        }

        return dp[n][target] = (take + notTake);
    }
}