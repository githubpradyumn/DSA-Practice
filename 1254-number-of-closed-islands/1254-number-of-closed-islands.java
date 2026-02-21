class Solution {
    class Pair {
        int row, col;
        Pair(int row, int col){
            this.row=row;
            this.col=col;
        }
    }
    int[] rowDirections = {0,0,-1,1};
    int[] colDirections = {-1,1,0,0};
    public boolean isValid(int row, int col, int totalRows, int totalCols){
        return (row>=0 && col>=0 && row<totalRows && col<totalCols);
    }
    public int closedIsland(int[][] grid) {
        int totalRows = grid.length;
        int totalCols = grid[0].length;
        int count = 0;
        int[][] isVisited = new int[totalRows][totalCols];
        for(int i=0;i<totalCols;i++){
            if(grid[0][i]==0 && isVisited[0][i]==0){
                bfs(grid,isVisited,0,i,totalRows,totalCols);
            }    
            if(grid[totalRows-1][i]==0 && isVisited[totalRows-1][i]==0){
                bfs(grid,isVisited,totalRows-1,i,totalRows,totalCols);
            }    
        }
        for(int i=0;i<totalRows;i++){
            if(grid[i][0]==0 && isVisited[i][0]==0){
                bfs(grid,isVisited,i,0,totalRows,totalCols);
            }    
            if(grid[i][totalCols-1]==0 && isVisited[i][totalCols-1]==0){
                bfs(grid,isVisited,i,totalCols-1,totalRows,totalCols);
            }    
        }
        for(int i=0;i<totalRows;i++){
            for(int j=0;j<totalCols;j++){
                if(grid[i][j]==0 && isVisited[i][j]==0){
                    bfs(grid,isVisited,i,j,totalRows,totalCols);
                    count++;
                }
            }
        }
        return count;
    }
    public void bfs(int[][] grid, int[][] isVisited, int row, int col, int totalRows, int totalCols){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row,col));
        isVisited[row][col]=1;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            for(int i=0;i<4;i++){
                int currRow = curr.row + rowDirections[i];
                int currCol = curr.col + colDirections[i];
                if(isValid(currRow,currCol,totalRows,totalCols) && grid[currRow][currCol]==0 && isVisited[currRow][currCol]==0){
                    isVisited[currRow][currCol]=1;
                    q.add(new Pair(currRow,currCol));
                }
            }
        }
    }
}