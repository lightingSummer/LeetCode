package bit;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/21 0021
 * @description：
 */
public class 判断一个数是不是4的n次方342 {
    public boolean isPowerOfFour(int num) {
        return Integer.toString(num, 4).matches("10*");
        //num大于0 且是2的n次方 且只有一个奇数位为1
        //return num > 0 && (num & (num - 1)) == 0 && (num & 0b01010101010101010101010101010101) != 0;
    }
}
