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
        List<Integer> arr = new ArrayList<>();
        ListNode cur = head;

        while(cur != null){
            arr.add(cur.val);
            cur = cur.next;
        }
        Collections.sort(arr);
        cur = head;
        
        for(int val: arr){
            cur.val = val;
            cur = cur.next;
        }
        return head;
    }
}