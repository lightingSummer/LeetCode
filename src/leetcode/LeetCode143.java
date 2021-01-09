package leetcode;


/**
 * @author     ：lightingSummer
 * @date       ：2019/9/17 0017
 * @description：
 */
public class LeetCode143 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        reorderList(l1);
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head, fast = head, pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;

        ListNode cur = slow;
        pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        ListNode h = new ListNode(-1);
        ListNode newHead = h;
        while (head != null && pre != null) {
            h.next = head;
            head = head.next;
            h = h.next;
            h.next = pre;
            pre = pre.next;
            h = h.next;
        }
        if (head != null) {
            h.next = head;
        }
        if (pre != null) {
            h.next = pre;
        }
        head = newHead.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
