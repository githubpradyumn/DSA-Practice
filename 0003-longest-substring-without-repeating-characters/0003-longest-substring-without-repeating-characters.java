class Solution {
    public int lengthOfLongestSubstring(String s) {
        int st=0;
        int ed=0;
        // int currLength=0;
        int maxLength=0;
        Map<Character,Integer> map = new HashMap<>();

        while(ed<s.length()){
            char i = s.charAt(ed);
            map.put(i,map.getOrDefault(i,0)+1);
            // currLength++;

            if(map.get(i)==2){
                while(map.get(i)==2){
                    char e = s.charAt(st);
                    map.put(e,map.getOrDefault(e,0)-1);
                    st++;
                }
            }

            maxLength=Math.max(maxLength,ed-st+1);
            ed++;
        }
        return maxLength;
    }
       
}