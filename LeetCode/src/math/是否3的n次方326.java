package math;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/15 0015
 * @description：
 */
public class 是否3的n次方326 {
    public boolean isPowerOfThree(int n) {
        while (n > 1) {
            if (n % 3 != 0) {
                break;
            }
            n = n / 3;
        }
        return n == 1;
    }
}
