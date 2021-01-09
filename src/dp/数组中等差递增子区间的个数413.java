package dp;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/3 0003
 * @description： 数组中等差递增子区间的个数
 * dp[i] 表示以 A[i] 为结尾的等差递增子区间的个数。
 *
 * 当 A[i] - A[i-1] == A[i-1] - A[i-2]，那么 [A[i-2], A[i-1], A[i]] 构成一个等差递增子区间。
 * 而且在以 A[i-1] 为结尾的递增子区间的后面再加上一个 A[i]，一样可以构成新的递增子区间。
 */
public class 数组中等差递增子区间的个数413 {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null) {
            return 0;
        }
        int n = A.length;
        int[] dp = new int[n];
        for (int i = 2; i < n; i++) {
            if (A[i - 1] - A[i - 2] == A[i] - A[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int res = 0;
        for (int i = 2; i < n; i++) {
            res += dp[i];
        }
        return res;
    }
}
