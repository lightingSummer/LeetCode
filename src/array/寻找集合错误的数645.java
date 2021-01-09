package array;

import java.util.Arrays;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/24 0024
 * @description：
 */
public class 寻找集合错误的数645 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findErrorNums1(new int[]{1, 2, 2, 4})));
    }

    public static int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] res = new int[2];
        for (int i = 0; i < n; i++) {
            int temp = nums[i] > n ? nums[i] - n - 1 : nums[i] - 1;
            if (nums[temp] > n) {
                res[0] = temp + 1;
            } else {
                nums[temp] += n;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                res[1] = i + 1;
                break;
            }
        }
        return res;
    }

    public static int[] findErrorNums1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while  (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[]{nums[i], i + 1};
            }
        }
        return null;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
