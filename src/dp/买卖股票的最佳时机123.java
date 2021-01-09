package dp;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/11 0011
 * @description：
 */
public class 买卖股票的最佳时机123 {
    public int maxProfit1(int[] prices) {
        int buy1 = Integer.MIN_VALUE;
        int buy2 = Integer.MIN_VALUE;
        int sell1 = 0;
        int sell2 = 0;
        for (int price : prices) {
            buy1 = Math.max(buy1, -price);
            sell1 = Math.max(sell1, buy1 + price);
            buy2 = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, buy2 + price);
        }
        return sell2;
    }

    //可以交易两次
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int res = 0;
        int temp = 0;
        //分成两段
        for (int m = 1; m < n - 1; m++) {
            temp = 0;
            int min = Integer.MAX_VALUE;
            int money = 0;
            for (int i = 0; i <= m; i++) {
                money = Math.max(money, prices[i] - min);
                min = Math.min(min, prices[i]);
            }
            temp += Math.max(0, money);
            min = Integer.MAX_VALUE;
            money = 0;
            for (int i = m + 1; i < n; i++) {
                money = Math.max(money, prices[i] - min);
                min = Math.min(min, prices[i]);
            }
            temp += Math.max(0, money);
            res = Math.max(res, temp);
        }
        return res;
    }
}
