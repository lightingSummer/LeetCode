package serach.backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/13 0013
 * @description：
 */
public class 分割回文串178 {
    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), s);
        return res;
    }

    private static void dfs(List<List<String>> res, List<String> temp, String s) {
        if (0 == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            if (isPalindrome(s, 0, i - 1)) {
                String part = s.substring(0, i);
                temp.add(part);
                dfs(res, temp, s.substring(i));
                temp.remove(temp.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
