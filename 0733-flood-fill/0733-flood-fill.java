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

    public int[][] bfs(int[][] image,int[][] ans, int[][] isVisited,int color,int orgColor,int row,int col, int totalRows, int totalCols){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row,col));
        isVisited[row][col]=1;
        ans[row][col]=color;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            for(int i=0;i<4;i++){
                int newRow = curr.row + rowDirection[i];
                int newCol = curr.col + colDirection[i];
                if(isValid(newRow,newCol,totalRows,totalCols) && image[newRow][newCol]==orgColor && isVisited[newRow][newCol]==0){
                    q.add(new Pair(newRow,newCol));
                    isVisited[newRow][newCol]=1;
                    ans[newRow][newCol]=color;

                }
            }
        }
        return ans;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int totalRows = image.length;
        int totalCols = image[0].length;
        int[][] isVisited = new int[totalRows][totalCols];
        int[][] ans = image;
        int orgColor = image[sr][sc];
        
        // for(int i=sr;i<totalRows;i++){
            // for(int j=sc;j<totalCols;j++){
                // if(image[i][j]==orgColor && isVisited[i][j]==0){
                    bfs(image,ans,isVisited,color,orgColor,sr,sc,totalRows,totalCols);
                // }
            // }
        // }
        return ans;
    }
}