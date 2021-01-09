package serach.backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/12 0012
 * @description：
 */
public class 数字键盘组合17 {
    private char[][] letters = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        dfs(digits,0,new StringBuffer(),res);
        return res;
    }

    private void dfs(String digits, int index, StringBuffer sb, List<String> res) {
        if (index >= digits.length()) {
            res.add(sb.toString());
            return;
        }
        int num = digits.charAt(index) - '2';
        for (int i = 0; i < letters[num].length; i++) {
            sb.append(letters[num][i]);
            dfs(digits, index + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
