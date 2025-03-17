class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int res[] = new int[num_people];
        int idx = 0;
        int candie = 1;
        while(candies > 0){
            res[idx++ %num_people] += Math.min(candie, candies);
             candies -= candie;
            candie++;
        }
        return res;
    }
}