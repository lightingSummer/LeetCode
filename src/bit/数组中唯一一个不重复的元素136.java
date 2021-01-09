package bit;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/20 0020
 * @description：
 */
public class 数组中唯一一个不重复的元素136 {
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
