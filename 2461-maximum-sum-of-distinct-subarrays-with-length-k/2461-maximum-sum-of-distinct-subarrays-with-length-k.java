class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int right = 0;
        int left = 0;
        int duplicate = 0;

        long sum = 0;
        long answer = 0;

        Map<Integer, Integer> map = new HashMap<>();

        while (right < nums.length) {

            if (map.getOrDefault(nums[right], 0) == 1) {
                duplicate++;
            }

            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            sum += nums[right];

            while (right - left + 1 > k) {

                if (map.get(nums[left]) == 2) {
                    duplicate--;
                }

                map.put(nums[left], map.get(nums[left]) - 1);
                sum -= nums[left];

                left++;
            }

            if (right - left + 1 == k && duplicate == 0) {
                answer = Math.max(answer, sum);
            }

            right++;
        }

        return answer;
    }
}