class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
        for(int i=0; i<V; i++){
            adjlist.add(new ArrayList<>());
        }
        for(int[] e : edges){
            adjlist.get(e[0]).add(e[1]);
        }
        int[] indegree = new int[V];
        for(int i=0; i<V; i++){
            for(int nbh : adjlist.get(i)){
                indegree[nbh]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<V; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        ArrayList<Integer> ansList = new ArrayList<>();
        while(!q.isEmpty()){
            int curr = q.poll();
            ansList.add(curr);
            for(int nbh: adjlist.get(curr)){
                indegree[nbh]--;
                if(indegree[nbh]==0){
                    q.add(nbh);
                }
            }
                
        }
        return ansList;
    }
}