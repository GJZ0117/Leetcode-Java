package easy;

/**
 * 706. Design HashMap
 */

public class Design_HashMap {

    class MyHashMap {

        class Node {
            int key;
            int value;
            Node next;
        }

        Node[] array;

        public MyHashMap() {
            array = new Node[10];
            for (int i = 0; i < 10; i++) {
                array[i] = new Node();
            }
        }

        public void put(int key, int value) {
            int pos = key % 10;
            Node p = array[pos];
            while (p.next != null && p.next.key != key) {
                p = p.next;
            }

            if (p.next == null) {
                Node node = new Node();
                node.key = key;
                node.value = value;
                p.next = node;
            } else {
                p.next.value = value;
            }
        }

        public int get(int key) {
            int pos = key % 10;
            Node p = array[pos];
            while (p.next != null && p.next.key != key) {
                p = p.next;
            }

            if (p.next == null) {
                return -1;
            } else {
                return p.next.value;
            }

        }

        public void remove(int key) {
            int pos = key % 10;
            Node p = array[pos];
            while (p.next != null && p.next.key != key) {
                p = p.next;
            }
            if (p.next != null) {
                p.next = p.next.next;
            }
        }
    }

}
