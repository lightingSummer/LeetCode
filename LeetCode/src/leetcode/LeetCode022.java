package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：summerGit
 * @date ：2019/5/14 0014
 * @description：
 */
public class LeetCode022 {
    /**
     * author: summerGit
     * date: 2019/5/14 0014
     * description:
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        addParenthesis(list, "", 0, 0, n);
        return list;
    }

    public void addParenthesis(List<String> list, String str, int left, int right, int max) {
        if (str.length() == max * 2) {
            list.add(str);
            return;
        }
        if (left < max) {
            addParenthesis(list, str + "(", left + 1, right, max);
        }
        if (right < left) {
            addParenthesis(list, str + ")", left, right + 1, max);
        }
    }
}
