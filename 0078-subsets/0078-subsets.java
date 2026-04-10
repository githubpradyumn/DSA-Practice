class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer  = new ArrayList<>();
        Subsets(nums, 0, new ArrayList<>(), answer);
        return answer;
    }

    public void Subsets(int[] nums, int index, List<Integer> current, List<List<Integer>> answer) {
        if (index == nums.length) {
            answer.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        Subsets(nums, index + 1, current, answer);

        current.remove(current.size() - 1);
        Subsets(nums, index + 1, current, answer);
    }
}