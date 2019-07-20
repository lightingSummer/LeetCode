package bit;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/20 0020
 * @description：
 */
public class 数组中不重复的两个元素260 {
    public int[] singleNumber(int[] nums) {
        int temp = 0;
        for (int num : nums) {
            temp ^= num;
        }
        int i;
        for (i = 0; i < 32; i++) {
            if ((temp >> i & 1) == 1) {
                break;
            }
        }
        int[] res = new int[2];
        for (int num : nums) {
            if ((num >> i & 1) == 1) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}
