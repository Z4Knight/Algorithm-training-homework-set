class Solution {
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        Arrays.fill(f, 1000000000);
        f[0] = 0;
        for (int i = 1; i <= n; i++) {
            int squre = i * i;
            for (int j = squre; j <= n; j++) {
                f[j] = Math.min(f[j - squre] + 1, f[j]);
            }
        }
        return f[n];
    }
}
