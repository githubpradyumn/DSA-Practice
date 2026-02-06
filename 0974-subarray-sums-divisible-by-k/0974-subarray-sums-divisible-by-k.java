class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int currSum=0;
        int size=0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0; i<nums.length; i++){
            currSum+=nums[i];
            int need = (currSum%k);
            if(need<0){
                need+=k;
            }
            //check whether it is present in the map or not 
            if (map.containsKey(need)) {
                size += map.get(need);
            } 
            //always push the remainder in the map 
            map.put(need,map.getOrDefault(need,0)+1);
            
        }
        return size;
    }
}