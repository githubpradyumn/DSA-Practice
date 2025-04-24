class Solution {
    public int searchInsert(int[] nums, int target) {
        return binarysearch(nums,target);
    }
    static int binarysearch(int[] nums,int target){
       int start = 0;
       int end = nums.length - 1;
       while (start <= end) {
               // as middle value changes we place it inside the loop
               int mid =  start + (end-start)/2;
               if(nums[mid]==target){
                   return mid;
               } else if(target<nums[mid]) {
                   end = mid -1;
               } else {
                   start = mid+1;
               }
       }
       return start;
   }
}