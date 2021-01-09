package serach.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/12 0012
 * @description：
 */
public class 能到达的太平洋和大西洋的区域417 {
    private static int[][] dic = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        System.out.println(pacificAtlantic(matrix));
    }

    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] leftAndUpReturn = new boolean[m][n];
        boolean[][] rightAndDownReturn = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(matrix, i, 0, leftAndUpReturn);
            dfs(matrix, i, n - 1, rightAndDownReturn);
        }
        for (int j = 0; j < n; j++) {
            dfs(matrix, 0, j, leftAndUpReturn);
            dfs(matrix, m - 1, j, rightAndDownReturn);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (leftAndUpReturn[i][j] && rightAndDownReturn[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private static void dfs(int[][] matrix, int x, int y, boolean[][] hasVisited) {
        if (!hasVisited[x][y]) {
            hasVisited[x][y] = true;
            for (int[] d : dic) {
                int nextX = x + d[0];
                int nextY = y + d[1];
                if (nextX >= 0 && nextX < matrix.length && nextY >= 0 && nextY < matrix[0].length && matrix[x][y] <= matrix[nextX][nextY]) {
                    dfs(matrix, nextX, nextY, hasVisited);
                }
            }
        }
    }
}
