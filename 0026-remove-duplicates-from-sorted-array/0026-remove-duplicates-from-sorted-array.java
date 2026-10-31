class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==1){
            return 1;
        }
        int i = 0;
        int j = 1;
        int count = 1;
        while(j<nums.length){
            if(nums[j]==nums[i] && j<nums.length){
                j++;
            } else {
                swap(nums,i+1,j);
                count++;
                i++;
                j++;
            }
        }
        return count;
    }
    public void swap(int[] nums,int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}