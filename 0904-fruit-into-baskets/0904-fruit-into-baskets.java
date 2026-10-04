class Solution {
    public int totalFruit(int[] nums) {
        int right = 0, left = 0;
        int length = 1;
        Map<Integer,Integer> map = new HashMap<>();
        while(right<nums.length){
            int numsR = nums[right];
            map.put(numsR,map.getOrDefault(numsR,0)+1);
            while(map.size()>2){
                int numsL = nums[left];
                int value = map.get(numsL);
                map.put(numsL,value-1);
                if(map.get(numsL)==0){
                    map.remove(numsL);
                }
                left++;
            }
            length = Math.max(length,right-left+1);
            right++;
        }
        return length;
    }
}