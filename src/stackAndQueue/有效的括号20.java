package stackAndQueue;

import java.util.Stack;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/21 0021
 * @description：
 */
public class 有效的括号20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char temp = stack.pop();
                boolean b1 = c == ')' && temp == '(';
                boolean b2 = c == ']' && temp == '[';
                boolean b3 = c == '}' && temp == '{';
                if (!(b1 || b2 || b3)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
