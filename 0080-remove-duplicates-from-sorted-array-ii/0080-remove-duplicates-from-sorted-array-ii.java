class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 0;
        int k =0;
        while(i<n){
            int j = i;
            int count = 0;
            while((j<n)&& nums[i]==nums[j]){
                if(count<2){
                    nums[k] = nums[i];
                    k++;
                }
                count++;
                j++;
            }
            i = i + count;
        }
        return k;
    }
}