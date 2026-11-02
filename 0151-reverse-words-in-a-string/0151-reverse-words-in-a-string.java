class Solution {
    public String reverseWords(String s) {
        s  = s.trim();
        String[] st = s.split("\\s+");
        int right = 0;
        int left = st.length-1;
        while(right<left){
            String n = st[right];
            st[right] = st[left];
            st[left] = n;
            right++;
            left--;
        }
        return String.join(" ", st);
    }
}