package dp;

import java.util.Arrays;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/11 0011
 * @description： 只能进行k次的股票交易
 */
public class 买卖股票的最佳时机188 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k >= n / 2) {   // 这种情况下该问题退化为普通的股票交易问题
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for (int price : prices) {
            for (int i = 1; i <= k; i++) {
                buy[i] = Math.max(buy[i], sell[i - 1] - price);
                sell[i] = Math.max(sell[i], buy[i] + price);
            }
        }
        return sell[k];
    }
}
