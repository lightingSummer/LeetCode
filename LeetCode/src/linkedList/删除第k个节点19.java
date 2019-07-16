package linkedList;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/16 0016
 * @description： 找倒数第n+1个节点，并删之
 */
public class 删除第k个节点19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode fastNode = newHead;
        ListNode slowNode = newHead;
        for (int i = 0; i < n+1 ; i++) {
            fastNode = fastNode.next;
        }
        while (fastNode != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        slowNode.next = slowNode.next.next;
        return newHead.next;
    }
}
