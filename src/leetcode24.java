public class leetcode24 {
    /*leetcode24两两交换链表中的节点
    *给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
    你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     */
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }

        ListNode fNode = head;
        ListNode sNode = head.next;

        fNode.next = swapPairs(sNode.next);
        sNode.next = fNode;

        return sNode;
    }
}
