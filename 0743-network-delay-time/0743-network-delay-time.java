class Solution {
    class Pair {
        int node;
        int dist;

        Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }

    public int networkDelayTime(int[][] times, int V, int src) {
        ArrayList<ArrayList<Pair>> adjlist = new ArrayList<>();

        for(int i=0;i<V;i++){
            adjlist.add(new ArrayList<>());
        }

        for(int i=0;i<times.length;i++){

            int u = times[i][0]-1;
            int v = times[i][1]-1;
            int w = times[i][2];

            adjlist.get(u).add(new Pair(v,w));
            // adjlist.get(v).add(new Pair(u,w));
        }
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);

    //Priority Queue implementation
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> a.dist - b.dist
        );

        dist[src-1] = 0;
        pq.add(new Pair(src-1,0));

        
        while(!pq.isEmpty()){

            Pair curr = pq.poll();
            int node = curr.node;
            int currDist = curr.dist;

            for(Pair neighbour : adjlist.get(node)){

                int adjNode = neighbour.node;
                int weight = neighbour.dist;

                if(currDist + weight < dist[adjNode]){
                    dist[adjNode] = currDist + weight;
                    pq.add(new Pair(adjNode, dist[adjNode]));
                }
            }
        }
        int time = 0;
        for(int i=0;i<dist.length;i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            } else {
                time = Math.max(time,dist[i]);
            }
        }
        return time;
    }
}