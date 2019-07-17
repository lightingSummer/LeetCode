package hash;

import java.util.HashMap;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/17 0017
 * @description：
 */
public class 最长和谐序列594 {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> countForNum = new HashMap<>();
        for (int num : nums) {
            if (!countForNum.containsKey(num)) {
                countForNum.put(num, 0);
            }
            countForNum.put(num, countForNum.get(num) + 1);
        }
        int longest = 0;
        for (int num : countForNum.keySet()) {
            if (countForNum.containsKey(num + 1)) {
                longest = Math.max(longest, countForNum.get(num + 1) + countForNum.get(num));
            }
        }
        return longest;
    }
}
