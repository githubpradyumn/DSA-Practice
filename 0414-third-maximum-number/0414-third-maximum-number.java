public class Solution {
    public int thirdMax(int[] nums) {
        // Use Long instead of Integer to handle Integer.MIN_VALUE in the input
        Long firstMax = null;
        Long secondMax = null;
        Long thirdMax = null;
        
        for (Integer num : nums) {
            Long n = Long.valueOf(num);
            
            // Skip duplicates
            if (n.equals(firstMax) || n.equals(secondMax) || n.equals(thirdMax)) {
                continue;
            }
            
            // Update maximums accordingly
            if (firstMax == null || n > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = n;
            } else if (secondMax == null || n > secondMax) {
                thirdMax = secondMax;
                secondMax = n;
            } else if (thirdMax == null || n > thirdMax) {
                thirdMax = n;
            }
        }
        
        // If third maximum doesn't exist, return the maximum value
        if (thirdMax == null) {
            return firstMax.intValue();
        }
        
        return thirdMax.intValue();
    }
}