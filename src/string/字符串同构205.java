package string;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/22 0022
 * @description：
 */
public class 字符串同构205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] preIndexOfS = new int[256];
        int[] preIndexOfT = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);
            if (preIndexOfS[s1] != preIndexOfT[t1]) {
                return false;
            }
            preIndexOfS[s1] = i + 1;
            preIndexOfT[t1] = i + 1;
        }
        return true;
    }
}
