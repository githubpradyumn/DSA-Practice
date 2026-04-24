class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for(int num : nums) total+=num;
        if((total+target)%2!=0 || Math.abs(target)>total) return 0;
        int sum = (total + target)/2;
        int[] dp = new int[sum+1];
        dp[0]=1;
        for(int num: nums){
            for(int s=sum;s>=num;s--){
                dp[s]+=dp[s-num];
            }
        }
        return dp[sum];

    }
}