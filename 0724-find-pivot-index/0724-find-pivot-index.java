class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefixsum = new int[nums.length];
        int[] suffixsum = new int[nums.length];
        prefixsum[0]=nums[0];
        suffixsum[n-1]=nums[n-1];
        for(int i=1, j=n-2; i<n && j>=0; i++,j--){
            prefixsum[i] = prefixsum[i-1]+nums[i];
            suffixsum[j] = suffixsum[j+1]+nums[j];
        }
        // int pivot=-1;
        for(int i=0;i<n;i++){
            if(prefixsum[i]==suffixsum[i]){
                return i;
            }
        }
        return -1;
    }
}