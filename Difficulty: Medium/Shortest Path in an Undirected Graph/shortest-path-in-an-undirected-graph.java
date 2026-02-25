class Solution {

    class Pair {
        int node;
        int dist;

        Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }

    public List<Integer> shortestPath(int n, int m, int edges[][]) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e : edges){
            int u = e[0]-1;
            int v = e[1]-1;
            int w = e[2];

            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }

        int[] dist = new int[n];
        int[] parent = new int[n];

        Arrays.fill(dist,(int)1e9);

        for(int i=0;i<n;i++){
            parent[i]=i;
        }

        dist[0]=0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)->a.dist-b.dist
        );

        pq.add(new Pair(0,0));

        while(!pq.isEmpty()){

            Pair curr = pq.poll();
            int node = curr.node;
            int d = curr.dist;

            for(Pair neigh : adj.get(node)){

                int adjNode = neigh.node;
                int wt = neigh.dist;

                if(d+wt < dist[adjNode]){
                    dist[adjNode]=d+wt;
                    parent[adjNode]=node;
                    pq.add(new Pair(adjNode,dist[adjNode]));
                }
            }
        }

        if(dist[n-1]==(int)1e9){
            return Arrays.asList(-1);
        }

        List<Integer> path = new ArrayList<>();
        int node = n-1;

        while(parent[node]!=node){
            path.add(node+1);
            node=parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        path.add(0,dist[n-1]);

        return path;
    }
}