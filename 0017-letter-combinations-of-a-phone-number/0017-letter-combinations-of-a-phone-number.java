class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, char[]> keyboard = Map.of(
            '2', new char[] { 'a', 'b', 'c' },
            '3', new char[] { 'd', 'e', 'f' },
            '4', new char[] { 'g', 'h', 'i' },
            '5', new char[] { 'j', 'k', 'l' },
            '6', new char[] { 'm', 'n', 'o' },
            '7', new char[] { 'p', 'q', 'r', 's' },
            '8', new char[] { 't', 'u', 'v' },
            '9', new char[] { 'w', 'x', 'y', 'z' }
        );
        List<String> ans = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        int idx = 0;
        helper(digits, keyboard, ans, curr, idx);  
        return ans;
    }
    public void helper(String digits,Map<Character, char[]> keyboard,List<String> ans,StringBuilder curr,int idx){
        if(idx==digits.length()){
            ans.add(new StringBuilder(curr).toString());
            return;
        }
        char ch = digits.charAt(idx);
        char[] words = keyboard.get(ch);

        for(int i=0; i<words.length; i++){
            char current = words[i];
            curr.append(current);
            helper(digits, keyboard, ans, curr, idx+1);  
            curr.deleteCharAt(curr.length()-1); 
        }

    }
}