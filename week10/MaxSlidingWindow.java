class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // Pair<数值，位置>
        TreeSet<Pair<Integer, Integer>> ts = new TreeSet<>((p1, p2) -> p1.getKey() > p2.getKey() ? -1 : 1);

        int[] ans = new int[n - k + 1];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            ts.add(new Pair(nums[i], i));
            if (i >= k - 1) {
                Pair<Integer, Integer> p = ts.first();
                int maxVal = p.getKey();
                int valIdx = p.getValue();
                while (valIdx < i - k + 1 && !ts.isEmpty()) {
                    ts.pollFirst();
                    p = ts.first();
                    maxVal = p.getKey();
                    valIdx = p.getValue();
                }
                ans[idx++] = maxVal;
            }
        }

        return ans;
    }

    private Pair<Integer, Integer> getMax(Set<Pair<Integer, Integer>> ts) {
        for (Pair p : ts) {
            return p;
        }
        return null;
    }
}
