package twoDivSearch;

/**
 * @author     ：lightingSummer
 * @date       ：2019/6/25 0025
 * @description： 求旋转数组的最小数字
 */
public class LeetCode153 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
