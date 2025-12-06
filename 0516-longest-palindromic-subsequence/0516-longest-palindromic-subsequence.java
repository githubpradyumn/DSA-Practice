class Solution {
    Integer[][] dp;

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        dp = new Integer[n][n];
        return solve(s, 0, n - 1);
    }

    public int solve(String s, int i, int j) {
        if (i > j) return 0;    
        if (i == j) return 1;   

        if (dp[i][j] != null) return dp[i][j];

        if (s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = 2 + solve(s, i + 1, j - 1);
        }

        int left = solve(s, i + 1, j);
        int right = solve(s, i, j - 1);

        return dp[i][j] = Math.max(left, right);
    }
}
