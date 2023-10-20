class Node{
    int key, val;
    Node next;
    Node prev;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
    Node(int key, int val, Node prev, Node next) {
        this.key = key;
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}

class LRUCache {

    int capacity, curSize;
    //head always points to the LRU node
    //tail points to the recently used node
    Node head = null, tail = null;
    HashMap<Integer, Node> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;    
    }

    void print() {
        Node cur = head;
        System.out.println("");
        while(cur != null) {
            System.out.printf("%d -> ", cur.val);
            cur = cur.next;
        }
    }
    
    public int get(int key) {
        // System.out.println("\nBefore get:");
        // print();
        if(cache.containsKey(key)) {
            Node n = cache.get(key);
            if(n.next == null) {
                // do nothing, since the accessed node is already at tail
                // System.out.println("\nAfter get:");
                // print();
                return n.val;
            }
            Node prev = n.prev;
            Node next = n.next;
            
            //remove the node if node is in middle of list
            if(prev != null && next != null) {
                prev.next = next;
                next.prev = prev;
            }
            else {
                //remove if node is head
                head = head.next;
                head.prev = null;
            }

            //insert node at the end of list
            n.next = null;
            n.prev = tail;
            tail.next = n;
            tail = n;    
            // System.out.println("\nAfter get:");
            // print();
            return n.val;
        }
        else {
            // System.out.println("\nAfter get:");
            // print();
            return -1;
        }
    }
    
     public int get2(int key) {
        // System.out.println("\nBefore get:");
        // print();
        if(cache.containsKey(key)) {
            Node n = cache.get(key);
            if(n.next == null) {
                // do nothing, since the accessed node is already at tail
                // System.out.println("\nAfter get:");
                // print();
                return n.val;
            }
            Node prev = n.prev;
            Node next = n.next;
            
            //remove the node if node is in middle of list
            if(prev != null && next != null) {
                prev.next = next;
                next.prev = prev;
            }
            else {
                //remove if node is head
                head = head.next;
                head.prev = null;
            }

            //insert node at the end of list
            n.next = null;
            n.prev = tail;
            tail.next = n;
            tail = n;    
            // System.out.println("\nAfter get:");
            // print();
            return n.val;
        }
        else {
            // System.out.println("\nAfter get:");
            // print();
            return -1;
        }
    }
    
    public void put(int key, int value) {
        
        // System.out.println("\nBefore put:");
        // print();
        if(cache.containsKey(key)) {
            Node n = cache.get(key);
            n.val = value;
            cache.put(key, n); // not needed
        }
        else {
            Node n = new Node(key, value, tail, null);
            if(tail != null) {
                tail.next = n;
            }
            tail = n;
            if(head == null) {
                head = n;
            }
            if(curSize < capacity) {
                curSize++;
            }
            else{
                //evict lru node
                if(head != null) {
                    //delete from hashmap
                    cache.remove(head.key);
                    head = head.next;
                    if(head != null) {
                        head.prev = null;
                    }
                }
            }
             cache.put(key, n);
        }
        get2(key);
        // System.out.println("\nAfter put:");
        // print();
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */