class Solution {
    public int minMergedInteger(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i=1;i<nums.length;i+=2){
            String s1 = String.valueOf(nums[i-1]);
            String s2 = s1 + String.valueOf(nums[i]);
            if(min>Integer.valueOf(s2)){
                min = Integer.valueOf(s2);
            }
        }
        return min;
    }
}