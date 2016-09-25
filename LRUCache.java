public class LRUCache {
    
    class Node {
        int key;
        int val;
        Node pre;
        Node next;
    }
    
    private int count;
    private int capacity;
    private Node head;
    private Node tail;
    private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    
    private void insertToHead(Node node) {
        Node headnext = head.next;
        
        head.next = node;
        node.pre = head;
        node.next = headnext;
        headnext.pre = node;
    }
    
    private void removeNode(Node node) {
        Node nodepre = node.pre;
        Node nodenext = node.next;
        
        nodepre.next = nodenext;
        nodenext.pre = nodepre;
    }
    private void removeTail() {
        Node tailpre = tail.pre;
        this.removeNode(tailpre);
    }
    private void moveToHead(Node node) {
        this.removeNode(node);
        this.insertToHead(node);
    }
    
    // if visited, put it after the head. 
    // if there are a lot of elements than capacity, delete the tail-pre one.  
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        head = new Node();
        tail = new Node();
        
        head.next = tail;
        head.pre = null;
        
        tail.pre = head;
        tail.next = null;
    }
    
    public int get(int key) {
        //return the map.get(key);
        // put the visited node after head;
        if (!map.containsKey(key)) {
            return -1;
        }
        else {
            Node node = map.get(key);
            moveToHead(node);
            return node.val;
        }
    }
    
    public void set(int key, int value) {
        // if found, put it after the head. update the map. 
        // if not found, check the count and the capacity. 
        //if count == capacity, delete the tail-pre one, and then insert it after the head. update the map. (delete the old one, and add the new one)
        // if count < capacity, count++, insert it. update the map. (add the new one)
        
        if (map.containsKey(key)) {
            Node node = map.get(key);
            moveToHead(node);
            node.val = value;
            map.put(key, node);
        }
        else {
            if (count == capacity) {
                Node tailpre = tail.pre;
                map.remove(tailpre.key);
                removeTail();
                
            }
            else {
                count++;
            }
            Node node = new Node();
            node.key = key;
            node.val = value;
            insertToHead(node);
            map.put(key, node);
        }
    }
    
}