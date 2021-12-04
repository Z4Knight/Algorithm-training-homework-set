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
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int start, int end) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (start == end) {
            return lists[start];
        }
        if (start > end) {
            return null;
        }
        int mid = (end - start) / 2 + start;
        ListNode a = merge(lists, start, mid);
        ListNode b = merge(lists, mid + 1, end);
        return mergeTwoLists(a, b);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode last = ans;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                last.next = l1;
                l1 = l1.next;
            } else {
                last.next = l2;
                l2 = l2.next;
            }
            last = last.next;
        }
        last.next = l1 == null ? l2 : l1;
        return ans.next;
    }
}
