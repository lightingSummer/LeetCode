package likedQuestions;

/**
 * @author     ：lightingSummer
 * @date       ：2019/9/9 0009
 * @description：
 */
public class 跳跃游戏055 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int i = 0, max = 0;
        while (i < nums.length && i <= max) {
            max = Math.max(max, i + nums[i]);
            i++;
        }
        return max >= nums.length - 1;
    }
}
