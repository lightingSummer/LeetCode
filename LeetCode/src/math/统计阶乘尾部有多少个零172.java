package math;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/15 0015
 * @description：
 */
public class 统计阶乘尾部有多少个零172 {
    public int trailingZeroes(int n) {
        int res = 0;
        while (n > 0) {
            res += (n / 5);
            n /= 5;
        }
        return res;
    }
}
