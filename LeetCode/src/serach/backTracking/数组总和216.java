package serach.backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/13 0013
 * @description：
 */
public class 数组总和216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), k, n, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> temp, int k, int n, int index) {
        if (temp.size() == k && n == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < 10; i++) {
            if (i <= n && temp.size() < k) {
                temp.add(i);
                dfs(res, temp, k, n-i, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
