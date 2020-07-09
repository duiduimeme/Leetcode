public class leetcode83 {
    /*leetcode83删除排序链表中的重复元素
    *给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
    * */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
