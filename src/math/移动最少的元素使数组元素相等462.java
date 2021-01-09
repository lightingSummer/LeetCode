package math;

import java.util.Arrays;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/15 0015
 * @description：
 */
public class 移动最少的元素使数组元素相等462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int move = 0;
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            move += nums[h] - nums[l];
            l++;
            h--;
        }
        return move;
    }

    public static int minMoves1(int[] nums) {
        int n = nums.length;
        int midNum = findKthNum(nums, (n - 1) / 2);
        int res = 0;
        for (int num : nums) {
            res += Math.abs(num - midNum);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minMoves1(new int[]{1,3,2}));
    }

    private static int findKthNum(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int d = partition(nums, left, right);
            if (d == k) {
                return nums[d];
            } else if (d < k) {
                left = d + 1;
            } else {
                right = d - 1;
            }
        }
        return nums[0];
    }

    private static int partition(int[] nums, int left, int right) {
        int t = nums[left];
        int start = left;
        while (left < right) {
            while (left < right &&nums[right] >= t) {
                right--;
            }
            while (left < right &&nums[left] <= t) {
                left++;
            }
            swap(nums, left, right);
        }
        nums[start] = nums[left];
        nums[left] = t;
        return left;
    }


    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
