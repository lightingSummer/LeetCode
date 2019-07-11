package dp;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/11 0011
 * @description：
 */
public class 零钱兑换518 {
    public int change(int amount, int[] coins) {
        if (coins == null || amount < 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
