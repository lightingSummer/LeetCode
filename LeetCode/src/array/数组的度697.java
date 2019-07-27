package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/26 0026
 * @description：
 */
public class 数组的度697 {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> numCnt = new HashMap<>();
        Map<Integer, Integer> firstIndexOfNum = new HashMap<>();
        Map<Integer, Integer> lastIndexOfNum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!numCnt.containsKey(num)) {
                numCnt.put(num, 0);
            }
            numCnt.put(num, numCnt.get(num) + 1);
            lastIndexOfNum.put(num, i);
            if (!firstIndexOfNum.containsKey(num)) {
                firstIndexOfNum.put(num, i);
            }
        }
        int maxCnt = 0;
        for (int num : nums) {
            maxCnt = Math.max(maxCnt, numCnt.get(num));
        }
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int cnt = numCnt.get(num);
            if (cnt != maxCnt) {
                continue;
            }
            res = Math.min(res, lastIndexOfNum.get(num) - firstIndexOfNum.get(num) + 1);
        }
        return res;
    }
}
