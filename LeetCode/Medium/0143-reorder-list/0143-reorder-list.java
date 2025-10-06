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
    public ListNode findMid(ListNode head) {
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode Node) {
        ListNode prev=null;
        ListNode curr=Node;
        ListNode next;
        while(curr!=null) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public void merge(ListNode l1, ListNode l2) {
        while(l1!=null && l2!=null) {
            ListNode n1=l1.next;
            ListNode n2=l2.next;
            l1.next=l2;
            if(n1==null) {
                break;
            }
            l2.next=n1;
            l1=n1;
            l2=n2;
        }
    }
    public void reorderList(ListNode head) {
        ListNode list1=head;
        ListNode mid=findMid(head);
        ListNode list2=mid.next;
        mid.next=null;
        list2=reverse(list2);
        merge(list1, list2);
    }
}