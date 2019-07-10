package dp;

import java.util.Arrays;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/5 0005
 * @description：
 */
public class LeetCode376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] up = new int[n];
        int[] down = new int[n];
        Arrays.fill(up, 1);
        Arrays.fill(down, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    up[i] = Math.max(up[i], 1 + down[j]);
                } else if (nums[j] > nums[i]) {
                    down[i] = Math.max(down[i], 1 + up[j]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, Math.max(up[i], down[i]));
        }
        return res;
    }

    /**
     * @author: lightingSummer
     * @date: 2019/7/5 0005
     * @description: 大神算法  妙啊！！！！！！！
     * @param nums
     * @return int
     */
    public int wiggleMaxLength1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }
}
