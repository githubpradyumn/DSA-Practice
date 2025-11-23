class Solution {
    Integer[] dp;   // wrapper allows null

    public int rob(int[] nums) {
        dp = new Integer[nums.length];  // all values are null by default
        int n = nums.length - 1;
        return profit(nums, n);
    }

    public int profit(int[] nums, int n) {
        if(n == -1) return 0;
        if(n == 0) return nums[n];

        if(dp[n] != null) return dp[n];   // already computed

        int left = nums[n] + profit(nums, n - 2);
        int right = profit(nums, n - 1);

        return dp[n] = Math.max(left, right);
    }
}
