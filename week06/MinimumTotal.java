class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] f = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            List<Integer> rows = triangle.get(i);
            for (int j = 0; j < rows.size(); j++) {
                f[j] = Math.min(f[j], f[j + 1]) + rows.get(j);
            }
        }
        return f[0];
    }
}
