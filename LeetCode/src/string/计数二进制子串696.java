package string;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/22 0022
 * @description：
 */
public class 计数二进制子串696 {
    public int countBinarySubstrings(String s) {
        int preLen = 0;
        int curLen = 1;
        int cnt = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curLen++;
            } else {
                preLen = curLen;
                curLen = 1;
            }
            if (preLen >= curLen) {
                cnt++;
            }
        }
        return cnt;
    }
}
