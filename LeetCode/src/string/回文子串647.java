package string;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/22 0022
 * @description： 回文字符串：从字符串的某一位开始，尝试着去扩展子字符串。
 */
public class 回文子串647 {
    private int count = 0;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            extendSubstrings(s, i, i);
            extendSubstrings(s, i, i + 1);
        }
        return count;
    }

    private void extendSubstrings(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
}
