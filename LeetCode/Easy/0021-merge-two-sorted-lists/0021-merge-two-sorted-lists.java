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
    public ListNode mergeTwoLists(ListNode left, ListNode right) {
        ListNode merged = new ListNode(-1);
        ListNode temp = merged;
        while(left!=null && right!=null) {
			if(left.val<right.val) {
				temp.next=left;
				left=left.next;
			}
			else {
				temp.next=right;
				right=right.next;
			}
			temp=temp.next;
		}
		if(left!=null) {
			temp.next=left;
		}
		if(right!=null) {
			temp.next=right;
		}
        return merged.next;
    }
}