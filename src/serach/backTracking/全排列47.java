package serach.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/13 0013
 * @description：
 */
public class 全排列47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, res, temp, 0);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> temp, int index) {
        if (index == nums.length) {
            if (!res.contains(temp))
                res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
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

    /**
     * @author: lightingSummer
     * @date: 2019/7/13 0013
     * @description: 优化算法
     * @param nums
     * @return java.util.List<java.util.List < java.lang.Integer>>
     */
    public List<List<Integer>> permuteUnique1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] hasVisited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs1(nums, res, temp, 0, hasVisited);
        return res;
    }

    private void dfs1(int[] nums, List<List<Integer>> res, List<Integer> temp, int index, boolean[] hasVisited) {
        if (index == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && !hasVisited[i - 1]) {
                continue;
            }
            if (!hasVisited[i]) {
                temp.add(nums[i]);
                hasVisited[i] = true;
                dfs1(nums, res, temp, index + 1, hasVisited);
                hasVisited[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}
