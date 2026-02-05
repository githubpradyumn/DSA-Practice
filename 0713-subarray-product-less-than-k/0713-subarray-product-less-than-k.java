class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
       if (k <= 1) return 0;

        int st = 0;
        int prod = 1;
        int count = 0;

        for (int ed = 0; ed < nums.length; ed++) {
            prod *= nums[ed];

            while (prod >= k) {
                prod /= nums[st];
                st++;
            }
            count += (ed - st + 1);
        }

    return count;
    }
}