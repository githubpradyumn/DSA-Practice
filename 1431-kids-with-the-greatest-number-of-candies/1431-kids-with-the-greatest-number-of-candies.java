class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for(int num : candies){
            if(max<num){
                max = num;
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for(int num : candies){
            if(num+extraCandies >= max){
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }
}