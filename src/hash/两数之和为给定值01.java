package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/17 0017
 * @description：
 */
public class 两数之和为给定值01 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum1(new int[]{3, 2, 4}, 6)));
    }

    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp) && map.get(temp) != i) {
                res[0] = i;
                res[1] = map.get(temp);
                break;
            }
        }
        return res;
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] cp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int[] temp = new int[2];
        while (i < j) {
            if (nums[i] + nums[j] == target) {
                temp[0] = nums[i];
                temp[1] = nums[j];
                break;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        int[] res = new int[]{-1, -1};
        for (int l = 0; l < nums.length; l++) {
            if (cp[l] == temp[0] && res[0] == -1) {
                res[0] = l;
            }
            if (cp[l] == temp[1]) {
                res[1] = l;
            }
        }
        Arrays.sort(res);
        return res;
    }
}
