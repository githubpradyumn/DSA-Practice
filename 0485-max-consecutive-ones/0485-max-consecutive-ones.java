class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i = 0;
        int ans = 0;
        while(i<nums.length){
            int j = i;
            while(j<nums.length && nums[i]==1 && nums[j]==1){
                j++;
            }
            ans = Math.max(ans,j-i);
            j++;
            i=j;
        }
        return ans;
    }
}