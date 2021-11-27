class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] s = new int[n + 1];
        // s[0] = 0;
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + nums[i - 1];
        }
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        map.put(s[0], 1);
        for (int i = 1; i <= n; i++) {
            if (map.containsKey(s[i] - k)) {
                ans += map.get(s[i] - k);
            }
            int cnt = map.getOrDefault(s[i], 0);
            map.put(s[i], cnt + 1);
        }
        return ans;
    }
}
