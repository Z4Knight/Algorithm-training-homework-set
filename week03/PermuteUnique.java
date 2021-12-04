class Solution {

    private boolean[] used;

    private Set<String> hset = new HashSet<>();

    private List<Integer> chosen = new ArrayList<>();

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        recur(nums, 0);
        return ans;
    }

    private void recur(int[] nums, int pos) {
        // 边界
        String cStr = chosen.toString();
        if (pos == nums.length && !hset.contains(cStr)) {
            hset.add(cStr);
            ans.add(new ArrayList<>(chosen));
            return;
        }
        // process
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                chosen.add(nums[i]);
                used[i] = true;
                recur(nums, pos + 1);
                // 还原
                used[i] = false;
                chosen.remove(chosen.size() - 1);
            }
        }
    }
}
