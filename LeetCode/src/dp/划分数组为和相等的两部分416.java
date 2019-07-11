package dp;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/9 0009
 * @description： 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class 划分数组为和相等的两部分416 {
    public boolean canPartition(int[] nums) {
        if (nums == null) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int l = sum / 2;
        boolean[] dp = new boolean[l + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = l; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[l];
    }
}
