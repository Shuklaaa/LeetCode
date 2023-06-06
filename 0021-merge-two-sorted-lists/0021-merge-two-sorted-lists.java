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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1== null){
            return list2;
        }   
        if(list2 == null){ 
            return list1;
        }
        if(list1.val>list2.val){  // if value of list1 is greater than value of list2, we swap the two, since we place result at l1, which has to contain the smaller value of the two linked list (since the next value in the linked list would be smaller of the two bigger values)
            ListNode temp = list1; // swapping l1 and l2 using a temp variable
            list1 = list2;
            list2 = temp;
        }
        ListNode res = list1;
        while(list1 !=null && list2!=null){
            ListNode tmp = null;
            while(list1 !=null && list1.val <=list2.val ){
                tmp = list1;
                list1 = list1.next;
            }
            tmp.next = list2;

            //swap 
            ListNode temp = list1;  // as l1>l2, we swap the values
            list1 = list2;
            list2 = temp;

        }
        return res;
    }
}