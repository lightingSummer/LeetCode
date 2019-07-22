package string;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/22 0022
 * @description：
 */
public class 一组字符集合可以组成的回文字符串的最大长度409 {
    public int longestPalindrome(String s) {
        int n = s.length();
        int res = 0;
        int[] chars = new int[256];
        for (char c : s.toCharArray()) {
            chars[c]++;
        }
        for (int i : chars) {
            res += (i / 2) * 2;
        }
        if (res < n) {
            res++;
        }
        return res;
    }
}
