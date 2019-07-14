package serach.backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/13 0013
 * @description：
 */
public class 全排列46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(nums, res, temp, 0);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> temp, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            temp.add(nums[index]);
            dfs(nums, res, temp, index + 1);
            temp.remove(temp.size() - 1);
            swap(nums, i, index);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
