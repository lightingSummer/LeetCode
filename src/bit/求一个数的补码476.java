package bit;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/21 0021
 * @description：
 */
public class 求一个数的补码476 {
    public int findComplement(int num) {
        if (num == 0) {
            return 1;
        }
        // 得到int d = 0b10000000000000000000000000000000;
        int t = 1 << 30;
        // 找到首位为1的位数
        while ((t & num) == 0) {
            t = t >> 1;
        }
        // 1000变为1111
        t = (t << 1) - 1;
        return num ^ t;
    }
}
