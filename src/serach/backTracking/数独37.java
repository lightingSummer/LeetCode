package serach.backTracking;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/13 0013
 * @description：
 */
public class 数独37 {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        dfs(board);
    }

    private boolean dfs(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (isValid(board, i, j, k)) {
                            board[i][j] = k;
                            if (dfs(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int i, int j, char c) {
        for (int d = 0; d < 9; d++) {
            if (board[d][j] == c || board[i][d] == c || board[3 * (i / 3) + d / 3][3 * (j / 3) + d % 3] == c) {
                return false;
            }
        }
        return true;
    }
}
