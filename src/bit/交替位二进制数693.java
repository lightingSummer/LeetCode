package bit;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/21 0021
 * @description：
 */
public class 交替位二进制数693 {
    public boolean hasAlternatingBits(int n) {
        // 全1
        int a = (n ^ (n >> 1));
        // 判断是否是全1
        return (a & (a + 1)) == 0;
    }
}
