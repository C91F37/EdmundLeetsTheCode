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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode ptr = ans;
        int carry = 0;  
        int sum;
        while (l1 != null || l2 != null || carry != 0) {
            sum = 0;
            ListNode next = new ListNode();
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (carry == 1) {
                sum += 1;
            }
            if (sum > 9) {
                carry = 1;
                sum = sum % 10;
            } else {
                carry = 0;
            }

            next.val = sum;
            ptr.next = next;
            ptr = ptr.next;
        }
        return ans.next;
    }
}
