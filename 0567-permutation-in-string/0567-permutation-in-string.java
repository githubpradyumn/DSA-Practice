class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq  = new int[26];
        int[] winFreq = new int[26];
        for(int i=0;i<s1.length();i++){
            freq[s1.charAt(i)-'a']++;
        }
        int right = 0, left = 0;
        while(right<s2.length()){
            winFreq[s2.charAt(right)-'a']++;
            while((right-left+1)>s1.length()){
                winFreq[s2.charAt(left)-'a']--;
                left++;
            }
            if((right-left+1)==s1.length()){
                if(Arrays.equals(freq,winFreq)){
                    return true;
                }
            }
            right++;
        }
        return false;
    }
}