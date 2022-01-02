class Solution {
    public int jump(int[] nums) {
      int n = nums.length;
      int[] f = new int[n];
      Arrays.fill(f, 1000000000);
      f[0] = 0;
      for (int i = 1; i < n; i++) {
          for (int j = 0; j < i; j++) {
              if (j + nums[j] >= i) {
                  f[i] = Math.min(f[j] + 1, f[i]);
              }
          }
      }
      return f[n - 1];
    }
}
