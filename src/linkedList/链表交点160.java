package linkedList;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/16 0016
 * @description：
 */
public class 链表交点160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = 0;
        int len2 = 0;
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        while (temp1 != null) {
            temp1 = temp1.next;
            len1++;
        }
        while (temp2 != null) {
            temp2 = temp2.next;
            len2++;
        }
        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < len2 - len1; i++) {
                headB = headB.next;
            }
        }

        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
