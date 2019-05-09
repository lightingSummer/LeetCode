/**
 * @author ：summerGit
 * @date ：2019/4/14 0014
 * @description：
 */
public class LeetCodeNC1 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        node1.next = node2;
        ListNode node = deleteDuplicates(node1);
        if (node != null) {
            while (node.next != null) {
                System.out.println(node.val);
                node = node.next;
            }
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode pre = fakeHead;
        while (head != null) {
            while (head.next != null && head.val == head.next.val)
                head = head.next;
            if (pre.next == head)
                pre = pre.next;
            else
                pre.next = head;
            head = head.next;
        }
        return fakeHead.next;
    }
}
