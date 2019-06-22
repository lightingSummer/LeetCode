package twoPointer;

/**
 * @author     ：lightingSummer
 * @date       ：2019/6/22 0022
 * @description：
 */
public class LeetCode633 {
    public boolean judgeSquareSum(int c) {
        int low = 0;
        int high = (int) Math.ceil(Math.pow(c, 0.5));
        while (low <= high) {
            int sum = low * low + high * high;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                low++;
            } else {
                high--;
            }
        }
        return false;
    }
}
