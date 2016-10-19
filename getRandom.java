public class RandomizedSet {
    
    
    class DNode {
        int val;
        DNode next;
        DNode prev;
        
        public DNode(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }
    
    class DList {
        DNode head;
        DNode tail;
        int size;
        
        public DList() {
            size = 0;
            head = new DNode(0);
            tail = new DNode(0);
            head.next = tail;
            head.prev = null;
            tail.prev = head;
            tail.next = null;
        }
        
        public void addNode(DNode node) {
            node.next = head.next;
            node.prev = head;
            head.next = node;
            node.next.prev = node;
            size++;
        }
        
        public void deleteNode(DNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
        
        public DNode getNode(int count) {
            DNode curr = head;
            
            while (curr != null && count > 0) {
                curr = curr.next;
                count--;
            }
            
            return curr;
        }
    }
    
    DList dList;
    Map<Integer, DNode> map;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        dList = new DList();
        map = new HashMap<Integer, DNode>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        else {
            DNode curr = new DNode(val);
            dList.addNode(curr);
            map.put(val, curr);
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            DNode curr = map.get(val);
            dList.deleteNode(curr);
            map.remove(val);
            return true;
        }
        else {
            return false;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        int count = dList.size;
        int x = random.nextInt(count) + 1;
        return dList.getNode(x).val;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */