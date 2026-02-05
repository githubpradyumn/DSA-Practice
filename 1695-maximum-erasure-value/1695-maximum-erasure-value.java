class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int windowStart=0;
        int windowEnd=0;
        int maxSum=0;
        int currSum=0;
        Map<Integer,Integer> map = new HashMap<>();
        while(windowEnd<nums.length){
            currSum+=nums[windowEnd];
            map.put(nums[windowEnd],map.getOrDefault(nums[windowEnd],0)+1);
            if(map.get(nums[windowEnd])==2){
                while(map.get(nums[windowEnd])==2){
                    currSum-=nums[windowStart];
                    map.put(nums[windowStart],map.getOrDefault(nums[windowStart],0)-1);
                    windowStart++;
                }
            }
            maxSum=Math.max(maxSum,currSum);
            windowEnd++;
        }
        return maxSum;
    }
}