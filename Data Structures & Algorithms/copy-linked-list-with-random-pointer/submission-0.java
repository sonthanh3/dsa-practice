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
        if(head == null) return null;

        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        map.put(cur, new Node(cur.val));

        while(cur != null){
            Node curClone = map.get(cur);
            if(cur.random != null && !map.containsKey(cur.random)){
                map.put(cur.random, new Node(cur.random.val));
            }
            Node randomClone = map.get(cur.random);
            curClone.random  = randomClone;

            if(cur.next != null && !map.containsKey(cur.next)){
                map.put(cur.next, new Node(cur.next.val));
            }
            Node nextClone = map.get(cur.next);
            curClone.next = nextClone;

            cur = cur.next;
        }
        return map.get(head);

    }
}
