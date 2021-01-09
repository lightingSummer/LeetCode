package greedy;

/**
 * @author     ：lightingSummer
 * @date       ：2019/6/25 0025
 * @description： 子数组最大的和
 */
public class LeetCode053 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int pre = nums[0];
        for(int i=1;i<nums.length;i++){
            pre = Math.max(nums[i],pre+nums[i]);
            res = Math.max(res,pre);
        }
        return  res;
    }
}
