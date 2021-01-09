package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * todo
 *
 * @author light
 * @date 2020/12/13 5:56 下午
 */
public class LeetCode1497 {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> countMap = new HashMap<>((int) (arr.length / 0.75f) + 1);
        for (int num : arr) {
            int rem = num % k;
            rem = rem < 0 ? rem + k : rem;
            countMap.put(rem, countMap.getOrDefault(rem, 0) + 1);
        }
        for (int num : arr) {
            int rem = num % k;
            rem = rem < 0 ? rem + k : rem;

            if (rem == 0 || 2 * rem == k) {
                if (countMap.get(rem) % 2 != 0) {
                    return false;
                }
            } else {
                int nowCount = countMap.get(rem);
                int otherCount = countMap.getOrDefault(k - rem, 0);
                if (nowCount != otherCount) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode1497 lc = new LeetCode1497();
        lc.canArrange(new int[]{1, 2, 3, 4, 5, 10, 6, 7, 8, 9}, 5);
    }
}
