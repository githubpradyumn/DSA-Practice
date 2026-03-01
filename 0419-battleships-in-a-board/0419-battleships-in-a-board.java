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

    public int countBattleships(char[][] board) {

        int totalRows = board.length;
        int totalCols = board[0].length;
        int count = 0;

        int[][] isVisited = new int[totalRows][totalCols];

        for(int i=0;i<totalRows;i++){
            for(int j=0;j<totalCols;j++){

                if(board[i][j]=='X' && isVisited[i][j]==0){
                    bfs(board,isVisited,i,j,totalRows,totalCols);
                    count++;
                }
            }
        }
        return count;
    }

    public void bfs(char[][] board, int[][] isVisited, int row, int col, int totalRows, int totalCols){

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row,col));
        isVisited[row][col]=1;

        while(!q.isEmpty()){

            Pair curr = q.poll();

            for(int i=0;i<4;i++){

                int newRow = curr.row + rowDirections[i];
                int newCol = curr.col + colDirections[i];

                if(isValid(newRow,newCol,totalRows,totalCols) &&
                   board[newRow][newCol]=='X' &&
                   isVisited[newRow][newCol]==0){

                    isVisited[newRow][newCol]=1;
                    q.add(new Pair(newRow,newCol));
                }
            }
        }
    }
}