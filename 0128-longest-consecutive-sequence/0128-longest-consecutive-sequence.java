class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Map<Integer,Integer> map = new TreeMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int idx = 0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            nums[idx] = entry.getKey();
            idx++;
        }
        int max = 1;
        int count = 1;
        for(int i=1;i<idx;i++){
            if(nums[i]-nums[i-1]==1){
                count++;
            } else {
                count = 1;
            }
            max = Math.max(max,count);
        }
        return max;
    }
}