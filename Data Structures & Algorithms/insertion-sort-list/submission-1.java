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
    public ListNode insertionSortList(ListNode head) {
        ListNode dum = new ListNode(0, head);
        ListNode prev = head, cur = head.next;

        while(cur != null){
            if(cur.val >= prev.val){
                prev = cur;
                cur = cur.next;
                continue;
            }

            ListNode temp = dum;
            while(temp.next.val < cur.val){
                temp = temp.next;
            }

            prev.next = cur.next;
            cur.next = temp.next;
            temp.next = cur;
            cur = prev.next;
        }
        return dum.next;
    }
}