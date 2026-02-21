class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1){
            return -1;
        }
        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjlist.add(new ArrayList<>());
        }
        for(int[] e : connections){
            adjlist.get(e[0]).add(e[1]);
            adjlist.get(e[1]).add(e[0]);
        }
        int[] isVisited = new int[n];
        int count = -1;
        for (int i = 0; i < n; i++) {
            if (isVisited[i] == 0) {
                bfs(adjlist, isVisited, i);
                count++;
            }
        }
        return count;
    }
    public void bfs(ArrayList<ArrayList<Integer>> adjlist,int[] isVisited,int source) {
        int V = adjlist.size();
        Queue<Integer> q = new LinkedList<>();
        isVisited[source] = 1;
        q.add(source);
        while(!q.isEmpty()){
            int currNode = q.poll();
            for(int nbh : adjlist.get(currNode)){
                if(isVisited[nbh]==0){
                    isVisited[nbh]=1;
                    q.add(nbh);
                }
            }
        }
    }   
}