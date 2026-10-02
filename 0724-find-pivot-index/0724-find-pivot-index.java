class Solution {
    public int pivotIndex(int[] nums) {
        int[] p = new int[nums.length];
        p[0] = nums[0];
        int[] s = new int[nums.length];
        s[nums.length-1] = nums[nums.length-1];
        // int answer = -1;
        for(int i=1,j=nums.length-2;i<nums.length&&j>=0;i++,j--){
            p[i] = nums[i]+p[i-1];
            s[j] = nums[j]+s[j+1];
        }
        for(int i=0;i<nums.length;i++){
            if(s[i]-p[i]==0){
                return i;
            }
        }
        return -1;
    }
}