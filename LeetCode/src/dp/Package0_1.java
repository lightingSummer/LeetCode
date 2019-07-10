package dp;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/9 0009
 * @description：
 */
public class Package0_1 {
    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        System.out.println(knapsack(8, 4, weights, values));
        System.out.println(knapsack1(8, 4, weights, values));
    }

    private static int knapsack(int W, int N, int[] weights, int[] values) {
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                if (j >= weights[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j - weights[i - 1]] + values[i - 1], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][W];
    }

    //空间降维
    private static int knapsack1(int W, int N, int[] weights, int[] values) {
        int[] dp = new int[W + 1];
        for (int i = 0; i < N; i++) {
            for (int j = W; j >= 1; j--) {
                if (j >= weights[i]) {
                    dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
                }
            }
        }
        return dp[W];
    }
}
