class Solution {
    public int lengthOfLIS(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i=1; i<n; i++){
            for(int j=i-1; j>=0; j--){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],1+dp[j]);
                }
            }
        }
        int max = 0;
        for(int i=0;i<n;i++){
            max=Math.max(max,dp[i]);
        }
        return max;
    }
    // public int lengthOfLIS(int[] nums) {
    //     int n = nums.length;
    //     int[][] dp = new int[n + 1][n + 1];
        
    //     for (int idx = n - 1; idx >= 0; idx--) {
    //         for (int prevIdx = idx - 1; prevIdx >= -1; prevIdx--) {
    //             int length = dp[idx + 1][prevIdx + 1];
    //             if (prevIdx == -1 || nums[idx] > nums[prevIdx]) {
    //                 length = Math.max(length, 1 + dp[idx + 1][idx + 1]);
    //             }
                
    //             dp[idx][prevIdx + 1] = length;
    //         }
    //     }
        
    //     return dp[0][0];
    // }
    // public int lengthOfLIS(int[] nums){
    //     int n = nums.length;
    //     int[][] dp = new int[n+1][n+1];
    //     for(int[] row: dp){
    //         Arrays.fill(row,-1);
    //     }
    //     return helper(nums,0,-1,dp);
    // }
    // public int helper(int[] nums, int idx, int prevIdx, int[][] dp){
    //     if(idx==nums.length) return 0;
    //     if(dp[idx][prevIdx+1]!=-1) return dp[idx][prevIdx+1];
    //     int notTake = helper(nums,idx+1,prevIdx,dp);
    //     int take = 0;
    //     if(prevIdx == -1 || nums[idx]>nums[prevIdx]){
    //         take = 1 + helper(nums,idx+1,idx,dp);
    //     }
    //     return dp[idx][prevIdx+1] = Math.max(take,notTake);
    // }
    // public int lengthOfLIS(int[] nums) {
    //     return helper(nums,0,-1);
    // }
    // public int helper(int[] nums, int idx, int prevIdx){
    //     if(idx==nums.length) return 0;
    //     int notTake = helper(nums,idx+1,prevIdx);
    //     int take = 0;
    //     if(prevIdx == -1 || nums[idx]>nums[prevIdx]){
    //         take = 1 + helper(nums,idx+1,idx);
    //     }
    //     return Math.max(take,notTake);
    // }
}