class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int windowStart = 0;
        int windowEnd = 0;
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        while(windowEnd<nums.length){
            currSum += nums[windowEnd];
            if(windowEnd>=k-1){
                maxSum=Math.max(maxSum,currSum);
                currSum -= nums[windowStart];
                windowStart++;
            }
            windowEnd++;
        }
        return (double) maxSum/k;
    }
}