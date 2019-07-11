package dp;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/10 0010
 * @description：
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 *
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *                   sum(P) - sum(N) = target
 * sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
 *                        2 * sum(P) = target + sum(nums)
 */
public class 改变一组数的正负号使得它们的和为一给定数494 {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (S > sum || (S + sum) % 2 != 0) {
            return 0;
        }
        int l = (S + sum) / 2;
        int[] dp = new int[l + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = l; i >= num; i--) {
                dp[i] = dp[i] + dp[i - num];
            }
        }
        return dp[l];
    }
}
