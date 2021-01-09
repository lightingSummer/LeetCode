package math;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/16 0016
 * @description：
 */
public class 三个数的最大乘积 {
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }

    /*
    private void findKthNum(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int res = partition(nums, left, right);
            if (k == res) {
                break;
            } else if (res < k) {
                left = res + 1;
            } else {
                right = res - 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        int i = left, j = right;
        int tar = nums[left];
        while (i < j) {
            while (i < j && nums[j] >= tar) {
                j--;
            }
            while (i < j && nums[i] <= tar) {
                i++;
            }
            swap(nums, i, j);
        }
        nums[left] = nums[i];
        nums[i] = tar;
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    */
}
