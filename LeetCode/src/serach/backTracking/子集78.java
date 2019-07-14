package serach.backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/13 0013
 * @description：
 */
public class 子集78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums, int index) {
        res.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            dfs(res, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
