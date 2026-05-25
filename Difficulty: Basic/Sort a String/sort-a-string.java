class Solution {
    public String sortString(String s) {
        
        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < 26; i++) {
            while (arr[i] > 0) {
                sb.append((char)(i + 'a'));
                arr[i]--;
            }
        }

        return sb.toString();
    }
}