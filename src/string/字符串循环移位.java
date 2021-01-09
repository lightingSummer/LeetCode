package string;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/21 0021
 * @description： 将字符串向右循环移动 k 位
 */
public class 字符串循环移位 {
    public static void main(String[] args) {
        System.out.println(rolRightString("abcd123", 3));
        System.out.println(rolLeftString("abcd123", 3));
    }

    /**
     * @author: lightingSummer
     * @date: 2019/7/21 0021
     * @description: 字符串向右移动k位
     * 先两边分别翻转，然后整体翻转
     * abcd123 -> dcba321 -> 123abcd
     */
    public static String rolRightString(String s, int k) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int n = s.length();
        k = k % n;
        String first = revString(s.substring(0, n - k));
        String second = revString(s.substring(n - k));
        return revString(first + second);
    }

    /**
     * @author: lightingSummer
     * @date: 2019/7/21 0021
     * @description: 字符串左移 先整体翻转，后两部分分别翻转
     * abcd123 —> 321dcba -> d123abc
     */
    public static String rolLeftString(String s, int k) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int n = s.length();
        k = k % n;
        s = revString(s);
        String first = revString(s.substring(0, n - k));
        String second = revString(s.substring(n - k));
        return first + second;
    }

    private static String revString(String str) {
        int n = str.length();
        char[] chars = str.toCharArray();
        for (int i = 0; i < n / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[n - 1 - i];
            chars[n - 1 - i] = temp;
        }
        return String.valueOf(chars);
    }
}
