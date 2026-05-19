import java.util.Arrays;

class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        if (n == 0) return 0;
        
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxChain = 1;
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxChain = Math.max(maxChain, dp[i]);
        }
        
        return maxChain;
    }
}