class Solution {
    Integer[] dp;   // for memoization

    public int maxValue(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0]; // If only one house

        // CASE 1: rob from 0 to n-2 (exclude last)
        dp = new Integer[n];
        int case1 = profit(nums, n - 2);

        // CASE 2: rob from 1 to n-1 (exclude first)
        dp = new Integer[n];
        int case2 = profit(nums, n - 1, true); // second variant

        return Math.max(case1, case2);
    }

    // normal recursive call starting from last index (case1)
    public int profit(int[] nums, int n) {
        if(n < 0) return 0;
        if(n == 0) return nums[0];

        if(dp[n] != null) return dp[n];

        int left = nums[n] + profit(nums, n - 2);
        int right = profit(nums, n - 1);

        return dp[n] = Math.max(left, right);
    }

    // recursive call for case2: start from index 1
    public int profit(int[] nums, int n, boolean isCase2) {
        if(n < 1) return 0;        // cannot go before index 1
        if(n == 1) return nums[1];

        if(dp[n] != null) return dp[n];

        int left = nums[n] + profit(nums, n - 2, true);
        int right = profit(nums, n - 1, true);

        return dp[n] = Math.max(left, right);
    }
}