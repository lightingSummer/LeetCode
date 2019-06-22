package leetcode;

/**
 * @author ：summerGit
 * @date ：2019/5/12 0012
 * @description：
 */
public class LeetCode019 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * author: summerGit
     * date: 2019/5/12 0012
     * description: 19. Remove Nth Node From End of List
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next=head;
        ListNode slow = fakeHead, fast = fakeHead;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next=slow.next.next;
        return fakeHead.next;
    }
}
