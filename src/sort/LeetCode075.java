package sort;

/**
 * @author     ：lightingSummer
 * @date       ：2019/6/24 0024
 * @description：
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * 其实本质和三向切分的快排一样
 */
public class LeetCode075 {
    public void sortColors(int[] nums) {
        int head = 0, left = 0, right = nums.length-1;
        while (left <= right) {
            if (nums[left] == 0) {
                swap(nums, left++, head++);
            } else if (nums[left] == 2) {
                swap(nums, left, right--);
            } else {
                left++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
