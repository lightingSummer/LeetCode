package serach.backTracking;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/13 0013
 * @description：
 */
public class 在矩阵中寻找字符串79 {
    int[][] dic = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return true;
        }
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        boolean res = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j]) {
                    boolean[][] hasVisited = new boolean[m][n];
                    hasVisited[i][j] = true;
                    res = dfs(board, i, j, word, hasVisited, 0);
                    if (res) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int x, int y, String word, boolean[][] hasVisited, int index) {
        if (index == word.length() - 1) {
            return true;
        }
        for (int[] d : dic) {
            int nextX = x + d[0];
            int nextY = y + d[1];
            if (nextX >= 0 && nextX < board.length && nextY >= 0 && nextY < board[0].length
                    && !hasVisited[nextX][nextY] && board[nextX][nextY] == word.charAt(index + 1)) {
                hasVisited[nextX][nextY] = true;
                if (dfs(board, nextX, nextY, word, hasVisited, index + 1)) {
                    return true;
                }
                hasVisited[nextX][nextY] = false;
            }
        }
        return false;
    }
}
