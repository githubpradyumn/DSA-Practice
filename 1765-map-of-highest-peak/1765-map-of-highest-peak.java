class Solution {
    
    class Pair{
        int row;
        int col;
        
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    
    int rowsDirection[] = {0,0,-1,1};
    int colsDirection[] = {-1,1,0,0};
    
    public boolean isValid(int r,int c,int totalRows,int totalCols){
        return (r>=0 && r<totalRows && c>=0 && c<totalCols);
    }
    
    public int[][] highestPeak(int[][] isWater) {
        
        int rows = isWater.length;
        int cols = isWater[0].length;
        
        int[][] height = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];
        
        bfs(isWater,height,visited,rows,cols);
        
        return height;
    }
    
    public void bfs(int[][] isWater, int[][] height, boolean[][] visited, int totalRows, int totalCols){
        
        Queue<Pair> q = new LinkedList<>();
        
        for(int i=0;i<totalRows;i++){
            for(int j=0;j<totalCols;j++){
                if(isWater[i][j]==1){
                    q.add(new Pair(i,j));
                    visited[i][j]=true;
                    height[i][j]=0;
                }
            }
        }
        
        while(!q.isEmpty()){
            
            Pair curr = q.poll();
            int currRow = curr.row;
            int currCol = curr.col;
            
            for(int i=0;i<4;i++){
                
                int newRow = currRow + rowsDirection[i];
                int newCol = currCol + colsDirection[i];
                
                if(isValid(newRow,newCol,totalRows,totalCols) && !visited[newRow][newCol]){
                    height[newRow][newCol] = height[currRow][currCol] + 1;
                    visited[newRow][newCol] = true;
                    q.add(new Pair(newRow,newCol));
                }
            }
        }
    }
}
