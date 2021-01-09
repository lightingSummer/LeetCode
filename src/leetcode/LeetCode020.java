package leetcode;

import java.util.Stack;

/**
 * @author ：summerGit
 * @date ：2019/5/14 0014
 * @description：
 */
public class LeetCode020 {
    /**
     * author: summerGit
     * date: 2019/5/14 0014
     * description:
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     * <p>
     * An input string is valid if:
     * <p>
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * Note that an empty string is also considered valid.
     */
    public boolean isValid(String s) {
        if (s == null) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']' && s.charAt(i) != ')' && s.charAt(i) != '}') {
                stack.push(s.charAt(i));
            } else {
                boolean find = false;
                while (!stack.isEmpty()){
                    char temp=stack.pop();
                    if(temp=='[' || temp=='(' || temp=='{'){
                        if((s.charAt(i)==']' && temp=='[')
                                ||(s.charAt(i)=='}' && temp=='{')
                                ||(s.charAt(i)==')' && temp=='(')){
                            find=true;
                        }
                        break;
                    }
                }
                if(!find){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
