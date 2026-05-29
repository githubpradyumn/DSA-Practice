class Solution {

    public int shipWithinDays(int[] weights, int days) {

        int low = 0, high = 0;
        for (int w : weights) {
            low = Math.max(low, w);
            high += w;
        }
        int result = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (isValid(weights, days, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
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