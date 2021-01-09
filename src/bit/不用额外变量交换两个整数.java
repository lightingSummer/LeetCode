package bit;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/20 0020
 * @description：
 */
public class 不用额外变量交换两个整数 {
    public int[] swap(int[] array) {
        array[0] = array[0] ^ array[1];
        array[1] = array[0] ^ array[1];
        array[0] = array[0] ^ array[1];
        return array;
    }
}
