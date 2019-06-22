package leetcode;

/**
 * @author ：summerGit
 * @date ：2019/5/9 0009
 * @description：
 */
public class LeetCode014 {
    /**
     * author: summerGit
     * date: 2019/5/9 0009
     * description: Write a function to find the longest common prefix string amongst an array of strings.
     * <p>
     * If there is no common prefix, return an empty string "".
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String pre = strs[0];
        int i = 1;
        while (i < strs.length) {
            while (strs[i].indexOf(pre) != 0)
                pre = pre.substring(0, pre.length() - 1);
            i++;
        }
        return pre;
    }
}
