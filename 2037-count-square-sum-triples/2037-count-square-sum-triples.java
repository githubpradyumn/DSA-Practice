class Solution {
    public int countTriples(int n) {
        int ans = 0;
        for (int a = 0; a <= n - 2; a++) {
            for (int b = a + 1; b <= n - 1; b++) {
                for (int c = b + 1; c <= n; c++) {

                    int LHS = a * a + b * b;
                    int RHS = c * c;

                    if (LHS == RHS) {
                        ans += 2;
                    }
                }
            }
        }
        return ans;
    }
}
