
import java.util.*;

class Edge {
    int v;
    int wt;

    Edge(int v, int wt) {
        this.v = v;
        this.wt = wt;
    }
}

@SuppressWarnings("unchecked")
class Solution {
    @SuppressWarnings("unchecked")
    public int spanningTree(int V, int[][] edges) {
        // ArrayList<Edge>[] adj = new ArrayList[V];
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
            // adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            // adj[u].add(new Edge(v, w));
            // adj[v].add(new Edge(u, w));
            adj.get(u).add(new Edge(v,w));
            adj.get(v).add(new Edge(u,w));
        }
        int[] vis = new int[V];
        PriorityQueue<Edge> pq = new PriorityQueue<>(
            (a, b) -> a.wt - b.wt
        );
        pq.add(new Edge(0, 0));

        int mstSum = 0;

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            int node = curr.v;
            int w = curr.wt;

            if (vis[node] == 0){

                vis[node] = 1;
                mstSum += w;

            for (Edge e : adj.get(node)) {
                if (vis[e.v] == 0) {
                    pq.add(new Edge(e.v, e.wt));
                }
            }
        }
    }

    return mstSum;
    }
}