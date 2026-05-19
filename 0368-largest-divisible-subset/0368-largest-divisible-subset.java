class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        int n = nums.length;
        if (n == 0) return answer;

        Arrays.sort(nums);
        
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
                if (nums[i] % nums[j] == 0 || nums[j]%nums[i]==0) {
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

        int curr = bestEndIndex;
        while (parent[curr] != curr) {
            answer.add(nums[curr]);
            curr = parent[curr];
        }
        answer.add(nums[curr]);
        
        Collections.reverse(answer);
        
        return answer;
    }
}

