class LRUCache {

    Map<Integer, Node> map = new HashMap<>();
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    int capacity;

    public class Node{
        int key, val; 
        Node pre, next;
        
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    public void add(Node newNode){
        newNode.next = head.next;
        newNode.pre = head;
        head.next.pre = newNode;
        head.next = newNode;
    }

    public void remove(Node delNode){
        delNode.pre.next = delNode.next;
        delNode.next.pre = delNode.pre;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node temp = map.get(key);
            remove(temp);
            add(temp);
            return temp.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node existing = map.get(key);
            existing.val = value;
            remove(existing);
            add(existing);
            return;
        }

        if(map.size() == capacity){
            Node LRU = tail.pre;
            remove(LRU);
            map.remove(LRU.key);
        }

        Node newNode = new Node(key, value);
        add(newNode);
        map.put(key, newNode);
    }
}
