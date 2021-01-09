package dp;

/**
 * @author     ：lightingSummer
 * @date       ：2019/6/26 0026
 * @description： 跑楼梯 一次一步或者两步
 */
public class 斐波那契数列070 {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int step1 = 1;
        int step2 = 2;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = step1 + step2;
            step1 = step2;
            step2 = res;
        }
        return res;
    }
}
