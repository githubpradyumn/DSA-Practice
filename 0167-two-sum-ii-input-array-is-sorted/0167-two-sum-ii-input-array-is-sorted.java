class Solution {
    public int[] twoSum(int[] nums, int target) {
        int start = 1;
        int end = nums.length ;

        while (start < end) {
            int sum = nums[start-1] + nums[end-1];

            if (sum == target) {
                return new int[]{start, end};
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }
        }

        return new int[]{-1, -1};
    }
}