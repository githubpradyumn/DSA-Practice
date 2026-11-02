class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int a = 0;
        int b = 0;
        while(a<word1.length() && b<word2.length()){
            sb = sb.append(word1.charAt(a));
            sb = sb.append(word2.charAt(b));
            a++;
            b++;
        }
        if(a==word1.length() && b!=word2.length()){
            while(b<word2.length()){
                sb.append(word2.charAt(b));
                b++;
            }
        }
        if(b==word2.length() && a!=word1.length()){
            while(a<word1.length()){
                sb.append(word1.charAt(a));
                a++;
            }
        }
        return sb.toString();
    }
}