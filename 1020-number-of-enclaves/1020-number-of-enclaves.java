class Solution {
    class Pair{
        int row , col;
        Pair(int row, int col){
            this.row=row;
            this.col=col;
        }
    }

    int rowDirection[] = {0,0,-1,1}; 
    int colDirection[] = {-1,1,0,0}; 
    
    public boolean isValid(int row, int col, int totalRows, int totalCols){
        return (row>=0 && col>=0 && row<totalRows && col<totalCols);
    }    

    public void bfs(int[][] grid, int[][] isVisited,int row,int col, int totalRows, int totalCols){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row,col));
        isVisited[row][col]=1;
        grid[row][col]=0;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            for(int i=0;i<4;i++){
                int newRow = curr.row + rowDirection[i];
                int newCol = curr.col + colDirection[i];
                if(isValid(newRow,newCol,totalRows,totalCols) && grid[newRow][newCol]==1 && isVisited[newRow][newCol]==0){
                    q.add(new Pair(newRow,newCol));
                    isVisited[newRow][newCol]=1;
                    grid[newRow][newCol]=0;
                }
            }
        }
    }
    public int numEnclaves(int[][] grid){

        int totalRows = grid.length;
        int totalCols = grid[0].length;
        int[][] isVisited = new int[totalRows][totalCols];
        int count = 0;

        for(int i=0;i<totalCols;i++){
            if(grid[0][i]==1 && isVisited[0][i]==0){
                bfs(grid,isVisited,0,i,totalRows,totalCols);
            }
            if(grid[totalRows-1][i]==1 && isVisited[totalRows-1][i]==0){
                bfs(grid,isVisited,totalRows-1,i,totalRows,totalCols);
            }
        }

        for(int i=0;i<totalRows;i++){
            if(grid[i][0]==1 && isVisited[i][0]==0){
                bfs(grid,isVisited,i,0,totalRows,totalCols);
            }
            if(grid[i][totalCols-1]==1 && isVisited[i][totalCols-1]==0){
                bfs(grid,isVisited,i,totalCols-1,totalRows,totalCols);
            }
        }

        for(int i=1;i<totalRows-1;i++){
            for(int j=1;j<totalCols-1;j++){
                if(grid[i][j]==1){
                    count++;
                }
            }
        } 
        return count;
    }    
}

