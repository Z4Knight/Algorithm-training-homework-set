class Solution {

    private int m;
    private int n;
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isEdge(i, j) && board[i][j] == 'O') {
                    bfs(i, j, board);
                    // dfs(i, j, board);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'Z') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(int x, int y, char[][] board) {
        if (!valid(x, y)) {
            return;
        }
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, 1, -1, 0};
        board[x][y] = 'Z';
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (valid(nx, ny) && board[nx][ny] == 'O') {
                dfs(nx, ny, board);
            }
        }
    }

    private void bfs(int i, int j, char[][] board) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair(i, j));
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, 1, -1, 0};
        board[i][j] = 'Z';
        while (!q.isEmpty()) {
            int x = q.peek().getKey();
            int y = q.peek().getValue();
            q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (valid(nx, ny) && board[nx][ny] == 'O') {
                    q.add(new Pair(nx, ny));
                    board[nx][ny] = 'Z';
                }
            }
        }
    }

    private boolean valid(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    private boolean isEdge(int x, int y) {
        return x == 0 || x == m - 1 || y == 0 || y == n - 1;
    }
}
