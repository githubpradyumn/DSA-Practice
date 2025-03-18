class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if(s.length()==1) return 1;
        int res =0;
        int index = s.length()-1;
        
        while(index>=0 && s.charAt(index)!=' '  ){

            res++;
            index--;
        }
        return res;
    }
}