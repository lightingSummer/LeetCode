package serach.backTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/13 0013
 * @description：
 */
public class 数组求和39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(res, temp, candidates, target, 0, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> temp, int[] candidates, int target, int sum, int index) {
        if (sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] + sum <= target) {
                temp.add(candidates[i]);
                dfs(res, temp, candidates, target, sum + candidates[i], i);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
