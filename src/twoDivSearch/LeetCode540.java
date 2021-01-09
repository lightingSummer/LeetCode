package twoDivSearch;

/**
 * @author     ：lightingSummer
 * @date       ：2019/6/25 0025
 * @description：
 */
public class LeetCode540 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(singleNonDuplicate(nums));
    }

    public static int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 0 && mid < nums.length - 1 && nums[mid] == nums[mid + 1]
                    || mid % 2 == 1 && nums[mid] == nums[mid - 1]) {
                left = mid + 1;
            } else if (mid % 2 == 0 && mid > 0 && nums[mid] == nums[mid - 1]
                    || mid % 2 == 1 && mid < nums.length && nums[mid] == nums[mid + 1]) {
                right = mid - 1;
            } else {
                return nums[mid];
            }
        }
        return nums[0];
    }

    public int sigle(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (m % 2 == 1) {
                m--;   // 保证 l/h/m 都在偶数位，使得查找区间大小一直都是奇数
            }
            if (nums[m] == nums[m + 1]) {
                l = m + 2;
            } else {
                h = m;
            }
        }
        return nums[l];
    }
}
