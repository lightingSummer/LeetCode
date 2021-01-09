package stackAndQueue;

import java.util.Stack;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/21 0021
 * @description：
 */
public class 用栈实现队列232 {
    private Stack<Integer> in;
    private Stack<Integer> out;

    public 用栈实现队列232() {
        in = new Stack<>();
        out = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        in2out();
        return out.pop();
    }

    private void in2out() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }


    /** Get the front element. */
    public int peek() {
        in2out();
        return out.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
