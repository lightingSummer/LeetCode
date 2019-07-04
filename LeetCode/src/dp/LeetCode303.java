package dp;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/3 0003
 * @description：
 */
public class LeetCode303 {
    private int[] nums;

    public LeetCode303(int[] nums) {
        this.nums = nums;
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return nums[j] - (i > 0 ? nums[i - 1] : 0);
    }
}
