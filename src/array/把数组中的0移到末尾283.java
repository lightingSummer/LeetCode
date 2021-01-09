package array;

import java.util.Arrays;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/24 0024
 * @description：
 */
public class 把数组中的0移到末尾283 {
    public static void main(String[] args) {
        int[] array = new int[]{0, 2, 4, 0, 23, 0};
        moveZeroes(array);
        System.out.println(Arrays.toString(array));
    }

    public void moveZeroes1(int[] nums) {
        int cnt = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[cnt++] = num;
            }
        }
        while (cnt < nums.length) {
            nums[cnt++] = 0;
        }
    }

    public static void moveZeroes(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                int j = i + 1;
                while (j < nums.length && nums[j] != 0) {
                    swap(nums, i++, j++);
                }
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
