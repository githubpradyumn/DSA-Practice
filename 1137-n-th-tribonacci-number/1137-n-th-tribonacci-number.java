class Solution {
    int[] DP;
    public int tribonacci(int n) {
        DP = new int[n+1];
        Arrays.fill(DP,-1);
        return solution(n,DP);
    }
    public int solution(int n, int[] dpArr){
        if(n<3 && n>0) return 1;
        if(n==0) return 0;
        if(dpArr[n]!=-1) return dpArr[n];
        return dpArr[n] = solution(n-2,dpArr) + solution(n-1,dpArr) + solution(n-3,dpArr);
    }
}