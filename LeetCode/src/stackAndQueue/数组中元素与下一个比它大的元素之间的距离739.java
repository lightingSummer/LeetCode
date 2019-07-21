package stackAndQueue;

import java.util.Stack;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/21 0021
 * @description：
 */
public class 数组中元素与下一个比它大的元素之间的距离739 {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] res = new int[n];
        // 用栈来存遍历过的index
        Stack<Integer> index = new Stack<>();
        for (int i = 0; i < n; i++) {
            // 找到了就出栈 栈里存的其实是一个递减的一堆索引
            while (!index.isEmpty() && T[i] > T[index.peek()]) {
                int preIndex = index.pop();
                res[preIndex] = i - preIndex;
            }
            index.push(i);
        }
        return res;
    }
}
