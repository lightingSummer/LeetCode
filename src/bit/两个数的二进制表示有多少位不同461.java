package bit;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/20 0020
 * @description：
 */
public class 两个数的二进制表示有多少位不同461 {
    public int hammingDistance(int x, int y) {
        int temp = x ^ y;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += temp & 1;
            temp = temp >> 1;
        }
        return res;
    }
}
