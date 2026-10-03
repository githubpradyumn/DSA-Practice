class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        int[] freq =  new int[26];
        for(int i=0;i<s1.length();i++){
            freq[s1.charAt(i)-'a']++;
        }
        int right = 0;
        int left = 0;
        int[] windowFreq = new int[26];
        while(right<s2.length()){
            windowFreq[s2.charAt(right)-'a']++;
            if((right-left)>=s1.length()-1){
                if(Arrays.equals(freq,windowFreq)){
                    return true;
                }
                windowFreq[s2.charAt(left)-'a']--;
                left++;
            }
            right++;
        }
        return false;
    }
}