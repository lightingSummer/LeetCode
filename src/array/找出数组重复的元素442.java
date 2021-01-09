package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/24 0024
 * @description：
 */
public class 找出数组重复的元素442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int index = nums[i] > n ? nums[i] - n - 1 : nums[i] - 1;
            if (nums[index] > n) {
                res.add(index + 1);
            } else {
                nums[index] += n;
            }
        }
        return res;
    }
}
