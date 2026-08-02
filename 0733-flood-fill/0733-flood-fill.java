class Solution {
    // pair class to store row and col in queue.
    class Pair{
        int row;
        int col;

        Pair(int row, int col){
            this.row=row;
            this.col=col;
        }
    }

    int row[] = {-1,1,0,0};
    int col[] = {0,0,1,-1};

    public boolean isValid(int row,int col, int m, int n){
        return (row>=0 && row<m && col>=0 && col<n);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int m = image.length;
        int n = image[0].length;
        int orgColor = image[sr][sc];
        if(orgColor==color){
            return image;
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr,sc));
        image[sr][sc] = color;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            for(int i=0;i<4;i++){
                int currRow = curr.row + row[i];
                int currCol = curr.col + col[i];
                if(isValid(currRow,currCol,m,n) && image[currRow][currCol]==orgColor){
                    image[currRow][currCol]=color;
                    q.add(new Pair(currRow,currCol));
                }
            }
        }
        return image;
    }
}