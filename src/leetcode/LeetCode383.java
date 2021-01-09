package leetcode;

/**
 * todo
 *
 * @author light
 * @date 2021/1/5 11:50 下午
 */
public class LeetCode383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            count[c - 'a']--;
        }
        for (int i : count) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }
}
