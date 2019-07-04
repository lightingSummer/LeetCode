package dp;

/**
 * @author     ：lightingSummer
 * @date       ：2019/6/26 0026
 * @description： 环形屋子分布 分开计算0 n-2  和 1 n-1即可
 */
public class LeetCode213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        return Math.max(compute(nums, 0, n - 2), compute(nums, 1, n - 1));
    }

    private int compute(int[] nums, int first, int last) {
        int pre2 = 0, pre1 = 0;
        for (int i = first; i <= last; i++) {
            int temp = Math.max(pre1, pre2 + nums[i]);
            pre2 = pre1;
            pre1 = temp;
        }
        return pre1;
    }
}
