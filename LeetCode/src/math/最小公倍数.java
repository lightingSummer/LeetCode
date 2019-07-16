package math;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/15 0015
 * @description： 最小公倍数为两数乘积除以最大公约数
 */
public class 最小公倍数 {
    public static void main(String[] args) {
        System.out.println(lcm(6,9));
        System.out.println(gcm(6,9));
    }

    public static int lcm(int a, int b) {
        return a * b / gcm(a, b);
    }

    private static int gcm(int a, int b) {
        return b == 0 ? a : gcm(b, a % b);
    }
}
