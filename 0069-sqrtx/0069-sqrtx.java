class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x; // Edge case
        
        int start = 1, end = x, ans = 0;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (mid == x / mid) { // Avoid overflow using division instead of multiplication
                return mid;
            } else if (mid < x / mid) { // mid^2 < x
                start = mid + 1;
                ans = mid; // Store possible answer
            } else {
                end = mid - 1;
            }
        }
        
        return ans; // Return the largest integer whose square ≤ x
    }
}
