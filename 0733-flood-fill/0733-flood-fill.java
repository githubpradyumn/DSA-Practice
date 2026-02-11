class Solution {
    class Pair{
        int row;
        int col;

        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    int[] rowDirection = {1,-1,0,0};
    int[] colDirection = {0,0,1,-1};

    public boolean isValid(int row,int col,int totalRows,int totalCols){
        if(row>=0 && row<totalRows && col>=0 && col<totalCols) return true;
        return false;
    }

    public int[][] bfs(int[][] image,int[][] colored,boolean[][] visited ,int sr, int sc, int color,int colour,int m,int n){

        Queue<Pair> q = new LinkedList<>();
        
        Pair p = new Pair(sr,sc);
        q.add(p);
        
        colored[sr][sc]=color;
        visited[sr][sc]=true;
        
        while(!q.isEmpty()){    

            Pair curr = q.poll();
            int currPairRow = curr.row;
            int currPairCol = curr.col;

            for(int i=0; i<4; i++){
                int newRow = currPairRow + rowDirection[i];
                int newCol = currPairCol + colDirection[i];  
                if(isValid(newRow,newCol,m,n) && image[newRow][newCol]==colour && visited[newRow][newCol]==false){
                    Pair newp = new Pair(newRow,newCol);
                    q.add(newp);
                    visited[newRow][newCol]=true;
                    colored[newRow][newCol]=color;
                }  
            }

        }
        return colored;
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int m = image.length;
        int n = image[0].length;

        int[][] colored = image;
        boolean[][] visited = new boolean[m][n];
        int colour = image[sr][sc];
        for(int i=sr;i<m;i++){
            for(int j=sc;j<m;j++){
                bfs(image,colored,visited,sr,sc,color,colour,m,n);
            }
        }
        return colored;
    }
}