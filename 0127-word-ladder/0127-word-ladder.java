class Solution {

    class Pair{
        String word;
        int dist;
        Pair(String word,int dist){
            this.word=word;
            this.dist=dist;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        HashSet<String> st = new HashSet<>(wordList);
        Queue<Pair> q = new LinkedList<>();
        
        if(!st.contains(endWord)) return 0;

        q.add(new Pair(beginWord,1));
        st.remove(beginWord);

        while(!q.isEmpty()){
            
            Pair curr = q.poll();
            String currString = curr.word;
            int length = curr.dist;

            char[] wordArr = currString.toCharArray();

            for(int i=0;i<currString.length();i++){

                char org = wordArr[i];

                for(char j='a'; j<='z'; j++){

                    wordArr[i] = j;
                    String newWord = new String(wordArr);

                    if(newWord.equals(endWord))
                        return length+1;

                    if(st.contains(newWord)){
                        q.add(new Pair(newWord,length+1));
                        st.remove(newWord);
                    }
                }

                wordArr[i] = org;
            }
        }

        return 0;
    }
}