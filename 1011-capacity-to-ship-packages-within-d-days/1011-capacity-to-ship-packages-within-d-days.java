class Solution {

    public int shipWithinDays(int[] weights, int days) {

        int low = 0;
        int high = 0;

        for (int w : weights) {
            low = Math.max(low, w);
            high += w;
        }

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (isValid(weights, days, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public boolean isValid(int[] weights, int days, int capacity) {

        int dayCount = 1;
        int load = 0;

        for (int w : weights) {

            if (load + w > capacity) {
                dayCount++;
                load = w;
            } else {
                load += w;
            }
        }

        return dayCount <= days;
    }
}