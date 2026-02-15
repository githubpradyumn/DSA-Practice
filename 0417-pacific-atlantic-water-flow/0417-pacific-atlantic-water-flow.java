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
    
    public void bfs(int row,int col, boolean[][] visited, int[][] heights, int totalRows, int totalCols){
        
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(row,col));
        visited[row][col] = true;
        
        while(!q.isEmpty()){
            
            Pair curr = q.poll();
            int currRow = curr.row;
            int currCol = curr.col;
            
            for(int i=0;i<4;i++){
                
                int newRow = currRow + rowsDirection[i];
                int newCol = currCol + colsDirection[i];
                
                if(isValid(newRow,newCol,totalRows,totalCols) && !visited[newRow][newCol] && heights[newRow][newCol] >= heights[currRow][currCol]){ 
                    visited[newRow][newCol] = true;
                    q.add(new Pair(newRow,newCol));
                }
            }
        }
    }
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        int rows = heights.length;
        int cols = heights[0].length;
        
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        
        // Pacific Borders
        for(int i=0;i<rows;i++){
            if(!pacific[i][0]){
                bfs(i,0,pacific,heights,rows,cols);
            }
        }

        
        for(int j=0;j<cols;j++){
            if(!pacific[0][j]){
                bfs(0,j,pacific,heights,rows,cols);
            }
        }
        
        // Atlantic Borders
        for(int i=0;i<rows;i++){
            if(!atlantic[i][cols-1]){
                bfs(i,cols-1,atlantic,heights,rows,cols);
            }
        }

        for(int j=0;j<cols;j++){
            if(!atlantic[rows-1][j]){
                bfs(rows-1,j,atlantic,heights,rows,cols);
            }
        }
        
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        
        return result;
    }
}
