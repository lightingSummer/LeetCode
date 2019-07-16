package math;

import java.util.Arrays;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/15 0015
 * @description：
 */
public class 乘积数组238 {
    public int[] productExceptSelf(int[] nums) {
        int left = 1;
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        for (int i = 1; i < n; i++) {
            left *= nums[i - 1];
            res[i] *= left;
        }
        int right = 1;
        for (int i = n - 2; i >= 0; i--) {
            right *= nums[i + 1];
            res[i] *= right;
        }
        return res;
    }

}
