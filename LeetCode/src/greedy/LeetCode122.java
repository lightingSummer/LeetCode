package greedy;

/**
 * @author     ：lightingSummer
 * @date       ：2019/6/24 0024
 * @description： 买股票2
 * 可以多次买卖  就是累加
 */
public class LeetCode122 {
    public int maxProfit(int[] prices) {
        int res = 0;
        for(int i=1;i<prices.length;i++){
            res += Math.max(0,prices[i]-prices[i-1]);
        }
        return res;
    }
}
