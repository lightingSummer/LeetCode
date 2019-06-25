package greedy;

/**
 * @author     ：lightingSummer
 * @date       ：2019/6/24 0024
 * @description： 一次买 一次卖
 */
public class LeetCode121 {

    public int maxProfit(int[] prices) {
        if(prices==null || prices.length<=1){
            return 0;
        }
        int min = prices[0];
        int res = 0;
        for(int i=1;i<prices.length;i++){
            res = Math.max(prices[i]-min,res);
            min = Math.min(prices[i],min);
        }
        return res;
    }
}
