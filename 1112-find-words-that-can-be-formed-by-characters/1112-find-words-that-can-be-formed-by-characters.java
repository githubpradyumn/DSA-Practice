class Solution {
    public int countCharacters(String[] words, String chars) {
        HashMap<Character,Integer> ans = new HashMap<>();
        for(int i=0;i<chars.length();i++){
            ans.put(chars.charAt(i),ans.getOrDefault(chars.charAt(i),0)+1);
        } 
        int s = 0;
        for(int i=0;i<words.length;i++){
            String str = words[i];
            int count=0;
         HashMap<Character,Integer> ans1 = new HashMap<>();
        for(int j=0;j<str.length();j++){
            ans1.put(str.charAt(j),ans1.getOrDefault(str.charAt(j),0)+1);
        } 
            for(char c : str.toCharArray()){
                if(ans.containsKey(c)){
                   if(ans1.get(c)<=ans.get(c)){
                       count++;
                   }
                }
                
            }
            if(count==str.length()){
                s+=str.length();
            }
        }
        return s;
    }
}