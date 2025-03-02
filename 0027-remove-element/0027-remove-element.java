class Solution {
     public static int removeElement(int[] nums, int val) {
        int pnt = 0;
        if (nums.length==0){
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[pnt] = nums[i];
                pnt++;
            }
        }
        return pnt;
    }
}