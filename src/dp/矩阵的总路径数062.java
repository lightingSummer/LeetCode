package dp;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/3 0003
 * @description：  矩阵的总路径数 从左上到右下有多少种走法
 */
public class 矩阵的总路径数062 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j]+ dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
