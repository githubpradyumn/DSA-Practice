// User function Template for Java

class Solution {
    public boolean isPossible(int N, int P, int[][] prerequisites) {
        // Your Code goes here
        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
        for(int i=0;i<N;i++) adjlist.add(new ArrayList<>());
        for(int[] e : prerequisites){
            adjlist.get(e[0]).add(e[1]);
        }
        return topoSort(N,adjlist);
    }
     public boolean topoSort(int V, ArrayList<ArrayList<Integer>> adjlist){
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] degree = new int[V];
        for(int i=0;i<V;i++){
            for(int nbh : adjlist.get(i)){
                degree[nbh]++;
            }
        }
        for(int i=0;i<V;i++){
            if(degree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            ans.add(curr);
            for(int nbh : adjlist.get(curr)){
                degree[nbh]--;
                if(degree[nbh]==0){
                    q.add(nbh);
                }
            }
        }
        if(ans.size()!=V){
            return false;
        }
        return true;
    }
}