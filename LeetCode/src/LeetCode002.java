/**
 * @author ：summerGit
 * @date ：2019/5/8 0008
 * @description：
 */
public class LeetCode002 {
    class ListNode {
      int val;
      ListNode next;
     ListNode(int x) { val = x; }
  }
    /**
     * author: summerGit
     * date: 2019/5/8 0008
     * description: You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
     *
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode fakeHead=new ListNode(0);
        ListNode node1=l1,node2=l2,curNode=fakeHead;
        int sum=0;
        while (node1!=null || node2!=null){
            sum=sum/10;
            if(node1!=null){
                sum+=node1.val;
                node1=node1.next;
            }
            if(node2!=null){
                sum+=node2.val;
                node2=node2.next;
            }
            curNode.next=new ListNode(sum%10);
            curNode=curNode.next;
        }
        if(sum/10==1){
            curNode.next=new ListNode(1);
        }
        return fakeHead.next;
    }
}
