class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1){
                sum += 1;
            }else{
                sum -= 1;
            }

            if (sum == 0) {
                maxLen = i + 1;
            }

            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
            
        }
        return maxLen;
    }
}