package bit;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/20 0020
 * @description：
 */
public class 找出数组中缺失的那个数268 {
    public int missingNumber(int[] nums) {
        int res = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            res = res ^ i ^ nums[i];
        }
        return res ^ n;
    }
}
