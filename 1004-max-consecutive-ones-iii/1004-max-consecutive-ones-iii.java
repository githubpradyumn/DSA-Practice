class Solution {
    public int longestOnes(int[] nums, int k) {
        int windowStart=0;
        int windowEnd=0;
        int maxLength=0;
        int countZero=0;

        while(windowEnd<nums.length){
            if(nums[windowEnd]==0) countZero++;

            while(countZero>k){
                if(nums[windowStart]==0) countZero--;
                windowStart++;
            }

            maxLength=Math.max(maxLength,windowEnd-windowStart+1);
            windowEnd++;
        }
        return maxLength;
    }
}