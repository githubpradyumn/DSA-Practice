class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] answer = new int[numCourses];
        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
        for(int i=0;i<numCourses;i++) adjlist.add(new ArrayList<>());
        for(int[] e : prerequisites){
          adjlist.get(e[1]).add(e[0]);
        }

        return topoSort(numCourses,adjlist,answer);
    }
    public int[] topoSort(int V, ArrayList<ArrayList<Integer>> adjlist,int[] answer){
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
            return new int[0];
        }
        for(int i=0;i<V;i++){
            answer[i]=ans.get(i);
        }
        return answer;
    }
}
