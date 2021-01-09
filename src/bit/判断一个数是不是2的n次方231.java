package bit;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/20 0020
 * @description：
 */
public class 判断一个数是不是2的n次方231 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
