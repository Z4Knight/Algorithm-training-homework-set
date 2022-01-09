class Solution {
    private int[] fa;
    private int m;
    private int n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        fa = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = nums(i, j);
                fa[idx] = idx;
            }
        }

        int[] dx = new int[]{0, 1};
        int[] dy = new int[]{1, 0};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                for (int k = 0; k < 2; k++) {
                    int ni = i + dx[k];
                    int nj = j + dy[k];
                    if (ni < 0 || ni >= m || nj < 0 || nj >= n) {
                        continue;
                    }
                    if (grid[ni][nj] == '1') {
                        unionSet(nums(i, j), nums(ni, nj));
                    }
                }
            }
        }
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = nums(i, j);
                if (find(idx) == idx && grid[i][j] == '1') {
                    ans++;
                }
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

    private int nums(int i, int j) {
        return i * n + j;
    }

}
