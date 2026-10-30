class Solution {
    public int lengthOfLongestSubstring(String s) {
        int right = 0;
        int left = 0;
        int length = 0;
        Map<Character,Integer> map = new HashMap<>();
        while(right<s.length()){
            char r = s.charAt(right);
            map.put(r,map.getOrDefault(r,0)+1);
            while(map.get(r)>1){
                char l = s.charAt(left);
                map.put(l,map.get(l)-1);
                left++;
            }
            length = Math.max(length,right-left+1);
            right++;
        }       
        return length;
    }
}