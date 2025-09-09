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
        PriorityQueue<ListNode> heap = new PriorityQueue<>(
            (a,b) -> a.val - b.val);

        for(int i=0; i<lists.length; i++) {
            if(lists[i] != null) {
                System.out.println(lists[i].val);
                heap.add(lists[i]);
            }
        }

        ListNode result = new ListNode(-1);
        ListNode tmp = result;

        while(!heap.isEmpty()) {
            ListNode node = heap.remove();
            if(node.next != null) {
                 heap.add(node.next);
            }
            tmp.next = node;
            tmp = tmp.next;
        }
        return result.next;
    }
}