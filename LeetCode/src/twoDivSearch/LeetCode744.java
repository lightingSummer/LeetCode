package twoDivSearch;

/**
 * @author     ：lightingSummer
 * @date       ：2019/6/25 0025
 * @description：
 */
public class LeetCode744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] - target > 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (letters[right] - target > 0) {
            return letters[right];
        } else {
            return letters[0];
        }

    }
}
