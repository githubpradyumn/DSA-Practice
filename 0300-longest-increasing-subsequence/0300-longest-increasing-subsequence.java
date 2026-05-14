class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        ArrayList<Integer> result = new ArrayList<>();
        result.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < result.get(0)) {
                result.set(0, nums[i]);
            } 
            else if (nums[i] > result.get(result.size() - 1)) {
                result.add(nums[i]);
            } 
            else {
                int start = 0;
                int end = result.size() - 1;
                while (start < end) {
                    int mid = start + (end - start) / 2;
                    if (result.get(mid) < nums[i]) {
                        start = mid + 1;
                    } else {
                        end = mid;
                    }
                }
                result.set(start, nums[i]);
            }
        }
        return result.size();
    }
}