package dp;

/**
 * @author     ：lightingSummer
 * @date       ：2019/6/26 0026
 * @description：
 */
public class LeetCode198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                continue;
            }
            if (i > 1) {
                nums[i] = Math.max(nums[i - 1], nums[i - 2] + nums[i]);
            } else {
                nums[i] = Math.max(nums[i], nums[i - 1]);
            }
        }
        return nums[nums.length - 1];
    }

    /**
     * @author: lightingSummer
     * @date: 2019/6/26 0026
     * @description: 抢劫 不能抢相邻的
     */
    public int rob1(int[] nums) {
        int pre2 = 0, pre1 = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.max(pre2 + nums[i], pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}
