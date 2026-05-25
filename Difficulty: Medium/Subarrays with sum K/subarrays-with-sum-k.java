class Solution {
    public int cntSubarrays(int[] arr, int k) {
        // code here
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int currPrefSum = 0;
        int count = 0;
        for(int num : arr){
            currPrefSum += num;
            if(map.containsKey(currPrefSum-k)){
                count += map.get(currPrefSum-k);
            }
            map.put(currPrefSum,map.getOrDefault(currPrefSum,0)+1);
        }
        return count;
    }
}