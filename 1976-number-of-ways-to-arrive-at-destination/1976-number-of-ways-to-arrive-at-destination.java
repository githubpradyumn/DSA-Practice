class Solution {

    class Pair {
        int node;
        long dist;

        Pair(int node, long dist){
            this.node = node;
            this.dist = dist;
        }
    }

    public int countPaths(int n, int[][] roads) {

        long mod = (long)(1e9 + 7);

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e : roads){
            int u = e[0];
            int v = e[1];
            int wt = e[2];

            adj.get(u).add(new Pair(v , wt));
            adj.get(v).add(new Pair(u , wt));
        }

        long[] dist = new long[n];
        long[] ways = new long[n];

        Arrays.fill(dist , Long.MAX_VALUE);

        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a , b) -> Long.compare(a.dist , b.dist)
        );

        pq.add(new Pair(0 , 0));

        while(!pq.isEmpty()){

            Pair curr = pq.poll();
            int u = curr.node;
            long d = curr.dist;

            for(Pair neigh : adj.get(u)){

                int v = neigh.node;
                long wt = neigh.dist;

                if(d + wt < dist[v]){
                    dist[v] = d + wt;
                    ways[v] = ways[u];
                    pq.add(new Pair(v , dist[v]));
                }
                else if(d + wt == dist[v]){
                    ways[v] = (ways[v] + ways[u]) % mod;
                }
            }
        }

        return (int)(ways[n-1] % mod);
    }
}