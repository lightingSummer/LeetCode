/**
 * @author ：summerGit
 * @date ：2019/5/8 0008
 * @description：
 */
public class LeetCode006 {
    /**
     * author: summerGit
     * date: 2019/5/8 0008
     * description: The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
     * (you may want to display this pattern in a fixed font for better legibility)
     */
    public String convert(String s, int numRows) {
        int n = numRows;
        if (n == 1 || n >= s.length()) return s;

        StringBuilder sb = new StringBuilder();
        int interval = 2 * n - 2;
        for (int row = 0; row < n; row++) {
            int step = interval - 2 * row;
            for (int col = row; col < s.length(); col += interval) {
                sb.append(s.charAt(col));
                if (step > 0 && step < interval && (col + step) < s.length()) {
                    sb.append(s.charAt(col + step));
                }
            }
        }
        return sb.toString();
    }
}
