class Solution {
    private int[] fa;
    public int[] findRedundantConnection(int[][] edges) {
        int n = 0;
        for (int[] edge : edges) {
            n = Math.max(n, Math.max(edge[0], edge[1]));
        }
        fa = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            fa[i] = i;
        }

        int[] ans = new int[2];
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            if (find(x) != find(y)) {
                unionSet(x, y);
            } else {
                ans[0] = x;
                ans[1] = y;
            }
        }
        return ans;
    }

    private void unionSet(int x, int y) {
        x = find(x);
        y = find(y);
        fa[x] = y;
    }

    private int find(int x) {
        if (x == fa[x]) {
            return x;
        }
        return fa[x] = find(fa[x]);
    }
}
