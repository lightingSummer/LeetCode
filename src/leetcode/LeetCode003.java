package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：summerGit
 * @date ：2019/5/8 0008
 * @description：
 */
public class LeetCode003 {
    /**
     * author: summerGit
     * date: 2019/5/8 0008
     * description: Given a string, find the length of the longest substring without repeating characters.
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int max = 0, left = 0, right = 0;
        while (right < s.length()) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right++));
            max = Math.max(max, set.size());
        }
        return max;
    }
}
