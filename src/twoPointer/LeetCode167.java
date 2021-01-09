package twoPointer;

/**
 * @author     ：lightingSummer
 * @date       ：2019/6/22 0022
 * @description： 排序数组两个数之和，双指针，一个前一个后
 */
public class LeetCode167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }
}
