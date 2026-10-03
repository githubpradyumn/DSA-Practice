class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> answer = new ArrayList<>();
        int n = s.length();
        int k = p.length();

        if (k > n) return new ArrayList<>();
        int[] freq =  new int[26];
        for(int i=0;i<k;i++){
            freq[p.charAt(i)-'a']++;
        }
        int right = 0;
        int left = 0;
        int[] windowFreq = new int[26];
        while(right<s.length()){
            windowFreq[s.charAt(right)-'a']++;
            if((right-left)>=p.length()-1){
                if(Arrays.equals(freq,windowFreq)){
                    answer.add(left);
                }
                windowFreq[s.charAt(left)-'a']--;
                left++;
            }
            right++;
        }
        return answer;
    }
}