class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> setOfNums1 = new HashSet<>();
        for(int ele: nums1){
            setOfNums1.add(ele);
        }
        Set<Integer> common = new HashSet<>();
        for(int ele: nums2){
            if(setOfNums1.contains(ele))
                common.add(ele);
        }
        int[] ans = new int[common.size()];
        int k     = 0;
        for(int ele: common){
            ans[k] = ele;
            k++;
        }
        return ans;
    }
}