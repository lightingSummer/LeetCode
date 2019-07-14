package serach.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/13 0013
 * @description：
 */
public class 含有相同元素的组合求和40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(res, temp, candidates, target, 0, new boolean[candidates.length]);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> temp, int[] candidates, int target, int index, boolean[] hasVisited) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > 0 && candidates[i - 1] == candidates[i] && !hasVisited[i - 1]) {
                continue;
            }
            if (candidates[i] <= target) {
                temp.add(candidates[i]);
                hasVisited[i] = true;
                dfs(res, temp, candidates, target - candidates[i], i + 1, hasVisited);
                hasVisited[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}
