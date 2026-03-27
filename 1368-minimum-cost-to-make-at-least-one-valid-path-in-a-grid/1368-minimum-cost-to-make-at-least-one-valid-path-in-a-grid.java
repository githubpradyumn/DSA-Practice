import java.util.*;

class Solution {

    static class Node {
        int r, c, cost;

        Node(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
    }

    public int minCost(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] dirs = {
            {0, 1},   
            {0, -1},  
            {1, 0},   
            {-1, 0}   
        };

        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);

        pq.add(new Node(0, 0, 0));
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            int r = curr.r;
            int c = curr.c;
            int cost = curr.cost;

            if (r == n - 1 && c == m - 1) return cost;

            for (int i = 0; i < 4; i++) {
                int nr = r + dirs[i][0];
                int nc = c + dirs[i][1];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;

                int newCost = cost + (grid[r][c] == i + 1 ? 0 : 1);

                if (newCost < dist[nr][nc]) {
                    dist[nr][nc] = newCost;
                    pq.add(new Node(nr, nc, newCost));
                }
            }
        }

        return -1;
    }
}