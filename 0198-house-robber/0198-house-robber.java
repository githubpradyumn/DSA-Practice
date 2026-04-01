class Solution {
    Integer[] dp;  

    public int rob(int[] nums) {
        dp = new Integer[nums.length];  
        // int n = nums.length - 1;
        return profit(nums, 0);
    }

    public int profit(int[] nums, int n) {
        // if(n > nums.length) return 0;
        if(n >= nums.length) return 0;

        if(dp[n] != null) return dp[n];  

        int left = nums[n] + profit(nums, n +2);
        int right = profit(nums, n +1);

        return dp[n] = Math.max(left, right);
    }
}
