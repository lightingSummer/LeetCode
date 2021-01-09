package array;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/24 0024
 * @description：
 */
public class 寻找重复数287 {
    public static void main(String[] args) {
        System.out.println(findDuplicate2(new int[]{1, 3, 4, 2, 4, 6, 5}));
    }

    /**
     * @author: lightingSummer
     * @date: 2019/7/24 0024
     * @description: 不可以改变数组 O(1)空间复杂度
     * 快慢指针，类似链表找环!!!!!!!!
     * @param nums
     * @return int
     */
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    /**
     * @author: lightingSummer
     * @date: 2019/7/24 0024
     * @description: 二分查找大法!!!!!!!
     * @param nums
     * @return int
     */
    public static int findDuplicate2(int[] nums) {
        int left = 1, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt++;
                }
            }
            if (cnt > mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * @author: lightingSummer
     * @date: 2019/7/24 0024
     * @description: 改变数组了
     * @param nums
     * @return int
     */
    public static int findDuplicate1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int index = nums[i] >= n ? nums[i] - n : nums[i];
            if (nums[index] >= n) {
                return index;
            } else {
                nums[index] += n;
            }
        }
        return -1;
    }
}
