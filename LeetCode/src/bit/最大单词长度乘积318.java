package bit;

import java.util.HashSet;
import java.util.Set;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/21 0021
 * @description：
 */
public class 最大单词长度乘积318 {
    public int maxProduct1(String[] words) {
        int n = words.length;
        int[] letter = new int[n];
        for (int i = 0; i < n; i++) {
            String word = words[i];
            for (char c : word.toCharArray()) {
                letter[i] |= (1) << (c - 'a');
            }
        }
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((letter[i] & letter[j]) == 0) {
                    res = Math.max(words[i].length() * words[j].length(), res);
                }
            }
        }
        return res;
    }

    public int maxProduct(String[] words) {
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (!hasCommonLetter(words[i], words[j])) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }

    private boolean hasCommonLetter(String a, String b) {
        Set<Character> set = new HashSet<>();
        for (char c : a.toCharArray()) {
            set.add(c);
        }
        for (char c : b.toCharArray()) {
            if (set.contains(c)) {
                return true;
            }
        }
        return false;
    }
}
