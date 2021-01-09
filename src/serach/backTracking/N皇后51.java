package serach.backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/13 0013
 * @description：
 */
public class N皇后51 {
    List<List<String>> res;
    boolean[] col;
    boolean[] limit1;
    boolean[] limit2;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        col = new boolean[n];
        limit1 = new boolean[2 * n - 1];
        limit2 = new boolean[2 * n - 1];
        dfs(n, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int n, int row, List<Integer> temp) {
        if (row == n) {
            toList(temp, n);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!col[i] && !limit1[row + i] && !limit2[n - 1 - (row - i)]) {
                col[i] = true;
                limit1[row + i] = true;
                limit2[row - i + n - 1] = true;

                temp.add(i);
                dfs(n, row + 1, temp);
                temp.remove(temp.size() - 1);

                col[i] = false;
                limit1[row + i] = false;
                limit2[row - i + n - 1] = false;
            }
        }
    }

    private void toList(List<Integer> temp, int n) {
        List<String> queens = new ArrayList<>();
        for (int col : temp) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < n; i++) {
                if (i == col) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            queens.add(sb.toString());
        }
        res.add(queens);
    }

}
