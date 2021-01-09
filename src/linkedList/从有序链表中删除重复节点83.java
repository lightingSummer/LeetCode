package linkedList;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/16 0016
 * @description：
 */
public class 从有序链表中删除重复节点83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(-1);
        ListNode h = newHead;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            h.next = cur;
            h = h.next;
            cur = cur.next;
        }
        return newHead.next;
    }
}
