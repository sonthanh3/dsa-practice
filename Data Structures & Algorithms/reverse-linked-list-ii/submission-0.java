/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right) return head;

        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode pre = dum;

        for(int i = 0; i < left - 1; i++){
            pre = pre.next;
        }

        ListNode cur = pre.next;

        for(int i = 0; i < right - left; i++){
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return dum.next;
    }
}