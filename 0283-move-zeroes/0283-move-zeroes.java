class Solution {
    public void moveZeroes(int[] nums) {
        int pnt = 0;
        for(int i = 0 ; i<nums.length ; i++){
            if (nums[i] != 0){
                nums[pnt] = nums[i];
                pnt++;
            }
        }
        for(int i = pnt ; i < nums.length ; i++){
            nums[i] = 0;
        }
    }
}