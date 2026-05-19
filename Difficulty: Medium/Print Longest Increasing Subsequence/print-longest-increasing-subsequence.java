class Solution {
    public ArrayList<Integer> getLIS(int arr[]) {
        int n = arr.length;
        if (n == 0) return new ArrayList<>();

        int[] dp = new int[n];
        int[] parent = new int[n];
        
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            parent[i] = i; 
        }

        int maxLength = 1;
        int bestEndIndex = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    if (1 + dp[j] > dp[i]) {
                        dp[i] = 1 + dp[j];
                        parent[i] = j;
                    }
                }
            }
    
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                bestEndIndex = i;
            }
        }

        
        ArrayList<Integer> result = new ArrayList<>();
        int curr = bestEndIndex;
        while (parent[curr] != curr) {
            result.add(arr[curr]);
            curr = parent[curr];
        }
        result.add(arr[curr]);
        
        Collections.reverse(result);
        
        return result;
    }
}