package stackAndQueue;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/21 0021
 * @description：
 */
public class 数组中下一个比它大的元素503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n*2; i++) {
            int num = nums[i%n];
            while (!stack.isEmpty() && num > nums[stack.peek()]) {
                int pre = stack.pop();
                res[pre] = num;
            }
            if(i<n){
                stack.push(i);
            }
        }
        return res;
    }
}
