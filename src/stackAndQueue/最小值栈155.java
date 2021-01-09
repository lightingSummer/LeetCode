package stackAndQueue;

import java.util.Stack;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/21 0021
 * @description：
 */
public class 最小值栈155 {
    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> min = new Stack<>();

    /** initialize your data structure here. */
    public 最小值栈155() {

    }

    public void push(int x) {
        in.push(x);
        min.push(min.isEmpty() ? x : Math.min(min.peek(), x));
    }

    public void pop() {
        in.pop();
        min.pop();
    }

    public int top() {
        return in.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
