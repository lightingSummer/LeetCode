package linkedList;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/16 0016
 * @description：
 */
public class 链表元素按奇偶聚集328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode odd = head, even = head.next, evenHead = even;
        // fast 是偶数 odd依赖even
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
