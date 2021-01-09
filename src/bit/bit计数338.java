package bit;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/21 0021
 * @description： 要求时间复杂度O(n)
 */
public class bit计数338 {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i >> 1] + (i & 1);
            // res[i] = res[i & (i-1)] + 1;
        }
        return res;
    }
}
