package math;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/15 0015
 * @description：
 */
public class 数组中出现次数大于一半的元素169 {
    public int majorityElement(int[] nums) {
        int n = nums[0];
        int cnt = 0;
        for (int i = 1; i < nums.length; i++) {
            if (n == nums[i]) {
                cnt++;
            } else {
                cnt--;
                if (cnt < 0) {
                    cnt = 0;
                    n = nums[i];
                }
            }
        }
        return n;
    }
}
