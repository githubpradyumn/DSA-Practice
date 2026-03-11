class Pair {
    int from;
    int to;
    int weight;

    Pair(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}

class DSU {
    int[] parent;
    int[] rank;

    DSU(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            return parent[x] = find(parent[x]);
        }
        return x;
    }

    public void union(int a, int b) {

        int pa = find(a);
        int pb = find(b);

        if (pa == pb)
            return;

        if (rank[pa] > rank[pb]) {
            parent[pb] = pa;
        } else if (rank[pa] < rank[pb]) {
            parent[pa] = pb;
        } else {
            parent[pb] = pa;
            rank[pa]++;
        }

    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        ArrayList<Pair> edges = new ArrayList<>();

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {

                int dist = Math.abs(points[i][0] - points[j][0]) +
                        Math.abs(points[i][1] - points[j][1]);

                edges.add(new Pair(i, j, dist));
            }
        }
        Collections.sort(edges, (a,b) -> a.weight - b.weight);

        DSU dsu = new DSU(points.length);

        int mstCost = 0;
        int edgesUsed = 0;

        for(Pair e : edges){

            int u = e.from;
            int v = e.to;
            int w = e.weight;

            if(dsu.find(u) != dsu.find(v)){

                dsu.union(u,v);
                mstCost += w;
                edgesUsed++;

                if(edgesUsed == n - 1) break;
            }
        }
        return mstCost;
    }
}