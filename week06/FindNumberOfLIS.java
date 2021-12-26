class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        // 最长递增子序列的长度
        int[] f = new int[n];
        // 最长递增子序列的个数
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = 1;
            cnt[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (f[j] + 1 > f[i]) {
                        f[i] = f[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (f[j] + 1 == f[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
        }
        int maxLen = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (f[i] > maxLen) {
                maxLen = f[i];
                ans = cnt[i];
            } else if (f[i] == maxLen) {
                ans += cnt[i];
            }
        }
        return ans;
    }
}
