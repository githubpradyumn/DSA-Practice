class Solution {
    class Pair{

        int row;
        int col;        

        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }

    }
    public boolean isValid(int row,int col,int totalRows,int totalCols){
        if(row>=0 && row<totalRows && col>=0 && col<totalCols) return true;
        return false;
    }

    int[] rowDirection = {1,-1,0,0};
    int[] colDirection = {0,0,1,-1};

    public void bfs(boolean[][] isVisited,int[][] grid,int row,int col,int totalRows, int totalCols){
        
        Queue<Pair> q = new LinkedList<>();
        Pair p = new Pair(row,col);
        q.add(p);
        isVisited[row][col] = true;
        grid[row][col]=0;
        
        while(!q.isEmpty()){
            Pair curr = q.poll();
            
            int currRow = curr.row;
            int currCol = curr.col;;
            
            for(int i=0;i<4;i++){
                
                int newRow = currRow + rowDirection[i];
                int newCol = currCol + colDirection[i];
                
                if(isValid(newRow,newCol,totalRows,totalCols) && grid[newRow][newCol]==1 && isVisited[newRow][newCol]==false){
                    Pair currPair = new Pair(newRow,newCol);
                    q.add(currPair);
                    isVisited[newRow][newCol]=true;
                    grid[newRow][newCol]=0;
                }
                
            }
        }
    }
    public int numEnclaves(int[][] grid){
        
        int totalRows=grid.length;
        int totalCols=grid[0].length;
        boolean[][] isVisited = new boolean[totalRows][totalCols];
        int count = 0;
        for(int i=0;i<totalCols;i++){
            if(grid[0][i]==1 && isVisited[0][i]==false){
                bfs(isVisited,grid,0,i,totalRows,totalCols);
            }
            if(grid[totalRows-1][i]==1 && isVisited[totalRows-1][i]==false){
                bfs(isVisited,grid,totalRows-1,i,totalRows,totalCols);
            }
        }
        for(int i=0;i<totalRows;i++){
            if(grid[i][0]==1 && isVisited[i][0]==false){
                bfs(isVisited,grid,i,0,totalRows,totalCols);
            }
            if(grid[i][totalCols-1]==1 && isVisited[i][totalCols-1]==false){
                bfs(isVisited,grid,i,totalCols-1,totalRows,totalCols);
            }
        }
        for(int i=0;i<totalRows;i++){
            for(int j=0;j<totalCols;j++){
                if(grid[i][j]==1){
                    // bfs(isVisited,grid,i,j,totalRows,totalCols);
                    count++;
                }
            }

        }
        return count;
    }
}
