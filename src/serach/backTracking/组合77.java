package serach.backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/13 0013
 * @description：
 */
public class 组合77 {
    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] hasVisited = new boolean[n];
        dfs(res, temp, k, n, 0);
        return res;
    }

    private static void dfs(List<List<Integer>> res, List<Integer> temp, int k, int n, int index) {
        if (temp.size() >= k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < n; i++) {
            temp.add(i + 1);
            dfs(res, temp, k, n, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
