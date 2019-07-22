package string;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/21 0021
 * @description： 只要限定了范围，并且比较小的话，使用数组代替HashMap比较快
 */
public class 有效的字母异同词242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
            chars[t.charAt(i) - 'a']--;
        }
        for (int i : chars) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

}
