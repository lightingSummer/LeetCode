package array;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/25 0025
 * @description：
 */
public class 数组相邻差值的个数667 {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        for (int i = 0, j = 1, l = k + 1; i <= k; i++) {
            if (i % 2 == 0) {
                res[i] = j++;
            } else {
                res[i] = l--;
            }
        }
        for (int i = k + 1; i < n; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
