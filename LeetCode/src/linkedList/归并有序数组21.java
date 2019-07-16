package linkedList;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/16 0016
 * @description：
 */
public class 归并有序数组21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode h = new ListNode(0);
        ListNode newHead = h;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                newHead.next = l1;
                l1 = l1.next;
            } else {
                newHead.next = l2;
                l2 = l2.next;
            }
            newHead = newHead.next;
        }
        while (l1 != null) {
            newHead.next = l1;
            l1 = l1.next;
            newHead = newHead.next;
        }
        while (l2 != null) {
            newHead.next = l2;
            l2 = l2.next;
            newHead = newHead.next;
        }
        return h.next;
    }
}
