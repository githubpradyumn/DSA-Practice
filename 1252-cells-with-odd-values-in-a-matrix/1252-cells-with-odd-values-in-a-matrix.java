class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] ansMatrix = new int[m][n];
        int count = 0;
        for(int i=0;i<indices.length;i++){
            int row = indices[i][0];
            int col = indices[i][1];
            for(int j=0;j<n;j++){
                ansMatrix[row][j]++;
            }
            for(int k=0;k<m;k++){
                ansMatrix[k][col]++;
            }
        }
        for(int j=0;j<m;j++){
            for(int k=0;k<n;k++){
                if(ansMatrix[j][k]%2!=0){
                    count++;
                }
            }
        }
        return (count);
    }
}