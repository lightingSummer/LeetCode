package serach.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/13 0013
 * @description：
 */
public class 子集90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(res, new ArrayList<>(), new boolean[nums.length], nums, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> temp, boolean[] hasVisited, int[] nums, int index) {
        res.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !hasVisited[i - 1]) {
                continue;
            }
            hasVisited[i] = true;
            temp.add(nums[i]);
            dfs(res, temp, hasVisited, nums, i + 1);
            temp.remove(temp.size() - 1);
            hasVisited[i] = false;
        }
    }
}
