package bit;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/20 0020
 * @description：
 */
public class 翻转一个数的bit位190 {
    public int reverseBits(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            ret <<= 1;
            ret |= (n & 1);
            n >>>= 1;
        }
        return ret;
    }
}
