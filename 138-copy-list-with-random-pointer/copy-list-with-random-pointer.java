/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        if(head == null) {
            return head;
        }
        
        Node oldHead = head;
        while(oldHead != null) {
            Node node = new Node(oldHead.val);

            // insert new node adjacent to old nodes
            node.next = oldHead.next;
            oldHead.next = node;

            oldHead = oldHead.next.next;
        }

        oldHead = head;
        Node newHead = oldHead.next;
        //update the random pointer
        while(oldHead != null) {
            Node randomNode = oldHead.random;
            if(randomNode != null) {
                newHead.random = randomNode.next;
            }
            //move to next node
            oldHead = oldHead.next.next;
            newHead = newHead.next != null ? newHead.next.next : null;
        }

        // separate the old list from new list
        oldHead = head;
        newHead = oldHead.next;
        Node newptr = newHead;
        while(oldHead != null) {
            oldHead.next = newHead.next;
            newHead.next = newHead.next != null ? newHead.next.next : null;

            oldHead = oldHead.next;
            newHead = newHead.next;
        }

        return newptr;
    }
}