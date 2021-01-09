package dp;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/3 0003
 * @description： 分割整数，求最大的乘积
 */
public class 分割整数的最大乘积343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], j * Math.max(dp[i - j], i - j));
            }
        }
        return dp[n];
    }
}
