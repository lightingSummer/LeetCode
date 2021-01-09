package twoDivSearch;

import java.util.Arrays;

/**
 * @author     ：lightingSummer
 * @date       ：2019/6/25 0025
 * @description：
 */
public class LeetCode034 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3, 5, 7, 8};
        System.out.println(Arrays.toString(searchRange(nums, 3)));
        System.out.println(Arrays.toString(searchRange1(nums, 3)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findNumLeft(nums, target);
        res[1] = findNumRight(nums, target);
        return res;
    }

    public static int[] searchRange1(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findLargeOrEqualNum(nums, target);
        res[1] = findLargeOrEqualNum(nums, target + 1) - 1;
        return res;
    }

    private static int findLargeOrEqualNum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left] >= target ? left : -1;
    }

    private static int findNumLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left < nums.length && nums[left] == target ? left : -1;
    }

    private static int findNumRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right >= 0 && nums[right] == target ? right : -1;
    }
}
