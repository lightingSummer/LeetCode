package stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/21 0021
 * @description：
 */
public class 用队列实现栈225 {
    private Queue<Integer> queue = new LinkedList<>();

    /** Initialize your data structure here. */
    public 用队列实现栈225() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
        int cnt = queue.size();
        while (cnt-- > 1) {
            queue.add(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.remove();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
