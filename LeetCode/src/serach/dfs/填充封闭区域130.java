package serach.dfs;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/12 0012
 * @description：
 */
public class 填充封闭区域130 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] hasVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X' || (i == 0 || i == m - 1 || j == 0 || j == n - 1)) {
                    dfs(board, i, j, board[i][j], hasVisited);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!hasVisited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int x, int y, char c, boolean[][] hasVisited) {
        if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && !hasVisited[x][y] && board[x][y] == c) {
            hasVisited[x][y] = true;
            dfs(board, x - 1, y, c, hasVisited);
            dfs(board, x + 1, y, c, hasVisited);
            dfs(board, x, y - 1, c, hasVisited);
            dfs(board, x, y + 1, c, hasVisited);
        }
    }
}
