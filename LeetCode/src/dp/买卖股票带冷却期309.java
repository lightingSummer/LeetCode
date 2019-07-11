package dp;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/10 0010
 * @description：
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 *
 * 对于买来说，当天是否买取决于买了之后是否比之前买所剩余的利润大，即状态转移方程为：
 *
 * buy[i] = max(buy[i-1], sell[i-2] - prices[i-1]);
 *
 *
 * 对于卖来说，同样当天是否将这只股票卖掉取决于卖掉能否获得更大的利润，状态转移方程为：
 *
 * sell[i] = max(sell[i-1], buy[i-1] + prices[i-1]);
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 买卖股票带冷却期309 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        //买是手中肯定有的
        int[] buy = new int[n + 1];
        //卖是手里有然后卖出去
        int[] sell = new int[n + 1];
        buy[1] = -prices[0];
        for (int i = 2; i <= n; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i - 1]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i - 1]);
        }
        return sell[n];
    }
}
