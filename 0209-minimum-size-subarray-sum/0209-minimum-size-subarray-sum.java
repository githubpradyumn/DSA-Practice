class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int windowStart = 0;
        int windowEnd = 0;
        int minimalLength = Integer.MAX_VALUE;
        int currSum = 0;

        while(windowEnd<nums.length){
            currSum += nums[windowEnd];
            if( currSum >= target ){
                minimalLength = Math.min(minimalLength,windowEnd-windowStart+1);
                while( currSum>=target ){
                    currSum -= nums[windowStart];
                    minimalLength = Math.min(minimalLength,windowEnd-windowStart+1);
                    windowStart++;
                }
            }
            windowEnd++;
        }
        if (minimalLength==Integer.MAX_VALUE) return 0;
        return minimalLength;
    }
}