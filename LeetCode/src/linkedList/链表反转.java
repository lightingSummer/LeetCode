package linkedList;

import java.util.Stack;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/16 0016
 * @description：
 */
public class 链表反转 {

    /**
     * @author: lightingSummer
     * @date: 2019/7/16 0016
     * @description: 栈时间复杂度O(n) 空间复杂度O(n)
     */
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode fakeHead = new ListNode(1);
        ListNode node = fakeHead;
        while (!stack.isEmpty()) {
            node.next = stack.pop();
            node = node.next;
        }
        node.next = null;
        return fakeHead.next;
    }

    /**
     * @author: lightingSummer
     * @date: 2019/7/16 0016
     * @description: 循环时间复杂度O(n) 空间复杂度O(1)
     */
    public ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        ListNode cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * @author: lightingSummer
     * @date: 2019/7/16 0016
     * @description: 递归时间复杂度O(n) 空间复杂度O(1)
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}
