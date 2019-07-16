package math;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/15 0015
 * @description： 辗转相除法
 */
public class 最大公约数 {
    public int gcd(int a, int b) {
        int res = a;
        while (b != 0) {
            int temp = a;
            a = b;
            b = a % b;
        }
        return res;
    }
}
