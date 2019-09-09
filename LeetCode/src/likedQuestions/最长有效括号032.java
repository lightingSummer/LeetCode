package likedQuestions;

import java.util.Stack;

/**
 * @author     ：lightingSummer
 * @date       ：2019/9/9 0009
 * @description：
 */
public class 最长有效括号032 {

    /**
     * @author: lightingSummer
     * @date: 2019/9/9 0009
     * @description: 用栈方法
     */
    public int longestValidParenthesesUseStack(String s) {
        Stack<Integer> stack = new Stack<>();
        int left = -1;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    left = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        max = Math.max(max, i - left);
                    } else {
                        max = Math.max(max, i - stack.peek());
                    }
                }
            }
        }
        return max;
    }


    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            findLongestValidParentheses(chars, i);
        }
        return res;
    }

    private int res = 0;

    private void findLongestValidParentheses(char[] chars, int index) {
        if (chars[index] == ')') {
            return;
        }
        int len = 1;
        int cnt = 1;
        for (int i = index + 1; i < chars.length; i++) {
            if (chars[i] == ')') {
                cnt--;
            } else {
                cnt++;
            }
            len++;
            if (cnt < 0) {
                break;
            } else if (cnt == 0) {
                res = Math.max(res, len);
            }
        }
    }
}
