package dp;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/4 0004
 * @description： 最长上升子序列
 */
public class LeetCode300 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println(lengthOfLIS(nums));
    }

    private static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            int j = i - 1;
            while (j >= 0) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    res = Math.max(dp[i], res);
                }
                j--;
            }
        }
        return res;
    }
}
