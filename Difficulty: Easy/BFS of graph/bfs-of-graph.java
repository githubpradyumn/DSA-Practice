class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> ansList = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] isVisited = new int[adj.size()];
        isVisited[0] = 1;
        q.add(0);
        while(!q.isEmpty()){
            int currNode = q.poll();
            ansList.add(currNode);
            for(int nbh : adj.get(currNode)){
                if(isVisited[nbh]==0){
                    isVisited[nbh] = 1;
                    q.add(nbh);
                }
            }
        }
        return ansList;
    }
}