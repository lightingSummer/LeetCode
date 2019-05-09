/**
 * @author ：summerGit
 * @date ：2019/5/8 0008
 * @description：
 */
public class LeetCode005 {
    /**
     * author: summerGit
     * date: 2019/5/8 0008
     * description: Given a string s,
     * find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
     */
    private int maxLen, left;

    public String longestPalindrome(String s) {
        maxLen = 0;
        left = 0;
        if (s.length() < 2) {
            return s;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            findPal(s, i, i);
            findPal(s, i, i + 1);
        }
        return s.substring(left, left + maxLen);
    }

    public void findPal(String s, int i, int k) {
        while (i >= 0 && k < s.length() && s.charAt(i) == s.charAt(k)) {
            i--;
            k++;
        }
        if (maxLen < k - i - 1) {
            left = i + 1;
            maxLen = k - i - 1;
        }
    }
}
