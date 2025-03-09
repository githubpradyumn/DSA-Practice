class Solution {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();

        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        int first = -1; 
        for (int temp : freqMap.values()) {
            if (first == -1) first = temp; 
            else if (temp != first) return false; 
        }

        return true;
    }
}