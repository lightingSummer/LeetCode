package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author     ：lightingSummer
 * @date       ：2019/5/29 0029
 * @description：
 * [[.,.,4,.,.,.,6,3,.]
 * ,[.,.,.,.,.,.,.,.,.]
 * ,[5,.,.,.,.,.,.,9,.]
 * ,[.,.,.,5,6,.,.,.,.]
 * ,[4,.,3,.,.,.,.,.,1]
 * ,[.,.,.,7,.,.,.,.,.]
 * ,[.,.,.,5,.,.,.,.,.]
 * ,[.,.,.,.,.,.,.,.,.]
 * ,[.,.,.,.,.,.,.,.,.]]
 */
public class LeetCode036 {

    public static void main(String[] args) {
        char[][] board={
                {'.','.','4','.','.','.','6','3','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'5','.','.','.','.','.','.','9','.'},
                {'.','.','.','5','6','.','.','.','.'},
                {'4','.','3','.','.','.','.','.','1'},
                {'4','.','3','.','.','.','.','.','1'},
                {'.','.','.','5','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'}
        };
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
        //行
        for (int i = 0; i < board.length; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                } else {
                    if (!set.add(board[i][j])) {
                        return false;
                    }
                }
            }
        }

        //列
        for (int i = 0; i< board[0].length; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == '.') {
                    continue;
                } else {
                    if (!set.add(board[j][i])) {
                        return false;
                    }
                }
            }
        }

        //方格
        for (int i = 0; i < board.length - 2; i = i + 3) {
            for (int j = 0; j < board[0].length - 2; j = j + 3) {
                Set<Character> set = new HashSet<>();
                for (int m = i; m < i + 3; m++) {
                    for (int n = j; n < j + 3; n++) {
                        if (board[m][n] == '.') {
                            continue;
                        } else {
                            if (!set.add(board[m][n])) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}