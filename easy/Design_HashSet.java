package easy;

/**
 * 705. Design HashSet
 */

public class Design_HashSet {
    class MyHashSet {

        class Node {
            int val;
            Node next;
        }

        Node[] nodeList;

        public MyHashSet() {
            nodeList = new Node[10];
            for (int i = 0; i < 10; i++) {
                nodeList[i] = new Node();
            }
        }

        public void add(int key) {
            int pos = key % 10;
            Node p = nodeList[pos];
            while (p.next != null && p.next.val!=key) {
                p = p.next;
            }
            if (p.next==null){
                Node node = new Node();
                node.val = key;
                p.next = node;
            }
        }

        public void remove(int key) {
            int pos = key % 10;
            Node p = nodeList[pos];
            while (p.next != null && p.next.val != key) {
                p = p.next;
            }
            if (p.next != null) {
                p.next = p.next.next;
            }
        }

        public boolean contains(int key) {
            int pos = key % 10;
            Node p = nodeList[pos].next;
            while (p != null) {
                if (p.val == key) {
                    return true;
                }
                p = p.next;
            }
            return false;
        }
    }
}
