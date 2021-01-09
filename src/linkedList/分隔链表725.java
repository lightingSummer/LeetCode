package linkedList;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/16 0016
 * @description：
 * 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
 *
 * 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
 *
 * 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
 *
 * 返回一个符合上述规则的链表的列表。
 *
 * 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
 *
 */
public class 分隔链表725 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
        node.next.next.next.next.next.next = new ListNode(7);
        System.out.println(splitListToParts(node, 3));
    }

    /**
     * @author: lightingSummer
     * @date: 2019/7/16 0016
     * @description: 大佬解法
     */
    public ListNode[] splitListToParts1(ListNode root, int k) {
        int N = 0;
        ListNode cur = root;
        while (cur != null) {
            cur = cur.next;
            N++;
        }
        int mod = N % k;
        int size = N / k;
        ListNode[] res = new ListNode[k];
        cur = root;
        for (int i = 0; i < k && cur != null; i++) {
            res[i] = cur;
            int cntSize = size + (mod-- > 0 ? 1 : 0);
            for (int j = 0; j < cntSize - 1; j++) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return res;
    }

    public static ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] list = new ListNode[k];
        ListNode temp = root;
        int cnt = 0;
        while (temp != null) {
            if (list[cnt % k] == null) {
                list[cnt % k] = new ListNode(0);
            } else {
                ListNode t = list[cnt % k];
                while (t.next != null) {
                    t = t.next;
                }
                t.next = new ListNode(0);
            }
            cnt++;
            temp = temp.next;
        }
        int d = 0;
        temp = list[0];
        while (root != null) {
            temp.val = root.val;
            root = root.next;
            if (root != null) {
                if (temp.next == null) {
                    d++;
                    temp = list[d];
                } else {
                    temp = temp.next;
                }
            }
        }
        return list;
    }
}
