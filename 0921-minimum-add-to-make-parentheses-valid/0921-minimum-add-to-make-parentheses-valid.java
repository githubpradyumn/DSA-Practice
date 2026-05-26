class Solution {
    public int minAddToMakeValid(String s) {
        int right = 0;
        int left = 0;
        // int valid = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                right++;
            } else if(s.charAt(i)==')' && right>0){
                right--;
            } else {
                left++;
            }
        }
        return (left+right);
    }
}