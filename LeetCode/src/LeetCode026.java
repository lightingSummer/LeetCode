/**
 * @author ：summerGit
 * @date ：2019/5/14 0014
 * @description：
 */
public class LeetCode026 {
    /**
     * author: summerGit
     * date: 2019/5/14 0014
     * description: Given a sorted array nums,
     * remove the duplicates in-place such that each element appear only once and return the new length.
     *
     * Do not allocate extra space for another array,
     * you must do this by modifying the input array in-place with O(1) extra memory.
     */
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i == 0 || n > nums[i-1])
                nums[i++] = n;
        return i;
    }
}
