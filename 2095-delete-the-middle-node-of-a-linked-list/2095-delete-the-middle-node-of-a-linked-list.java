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
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null){
            return null;
        }
            
        ListNode curr = head;
        int size = 0;
        
        while(curr != null){
            curr = curr.next;
            size++;
        }
        
        int mid = size / 2;
        
        ListNode prev = head;
        int i = 1;
        while(i < mid){
            i++;
            prev = prev.next;
        }
        
        prev.next = prev.next.next;
        
        return head;
    }
}