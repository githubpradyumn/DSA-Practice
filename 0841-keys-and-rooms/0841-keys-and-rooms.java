class Solution {
    public void bfs(List<List<Integer>> graph, boolean[] isVisited){
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        isVisited[0] = true;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int ngbr : graph.get(curr)){
                if(!isVisited[ngbr]){
                    q.add(ngbr);
                    isVisited[ngbr] = true;
                }
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] isVisited = new boolean[n];
        bfs(rooms, isVisited);

        for(boolean unlocked : isVisited){
            if(!unlocked) return false;
        }
        return true;
    }
}