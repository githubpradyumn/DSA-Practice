class Solution {
    public void rotate(int[] nums, int k) {
        if(k==0 || nums.length==1){
            return;
        }
        k = k%nums.length;
        change(nums,0,nums.length-1);
        change(nums,0,k-1);
        change(nums,k,nums.length-1);

    }
    public void change(int[] nums,int start,int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}