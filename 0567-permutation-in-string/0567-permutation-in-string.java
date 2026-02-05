class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> maps1 = new HashMap<>();
        Map<Character, Integer> maps2 = new HashMap<>();

        for(int i=0;i<s1.length();i++){
            char ch = s1.charAt(i);
            maps1.put(ch,maps1.getOrDefault(ch,0)+1);
        }

        int windowStart=0;
        int windowEnd=0;

        while(windowEnd<s2.length()){
            char ch = s2.charAt(windowEnd);
            maps2.put(ch,maps2.getOrDefault(ch,0)+1);
            
            if(windowEnd>=s1.length()-1){
                if(maps1.equals(maps2)) return true;
                char c = s2.charAt(windowStart);
                maps2.put(c,maps2.getOrDefault(c,0)-1);
                if(maps2.get(c)==0) maps2.remove(c);
                windowStart++;
            }
            windowEnd++;
        }

        return false;

    }
}