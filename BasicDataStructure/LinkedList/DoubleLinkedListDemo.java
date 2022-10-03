package BasicDataStructure.LinkedList;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        Node2 n1 = new Node2(2);
        Node2 n2 = new Node2(1);
        Node2 n3 = new Node2(5);
        Node2 n4 = new Node2(4);
        Node2 n5 = new Node2(3);

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(n1);
        doubleLinkedList.add(n2);
        doubleLinkedList.add(n3);
        doubleLinkedList.add(n4);
        doubleLinkedList.add(n5);

        doubleLinkedList.list();
        doubleLinkedList.del(2);
        doubleLinkedList.del(3);
        doubleLinkedList.list();
    }
}


/**
 * 双向链表类
 */
class DoubleLinkedList {
    //初始化头节点
    private Node2 head = new Node2(-1);

    //返回头节点
    public Node2 getHaed() {
        return head;
    }

    //遍历双向链表
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        Node2 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.print(temp + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    //添加一个节点到双向列表最后
    public void add(Node2 node) {
        Node2 temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    //删除一个节点
    public void del(int data) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        Node2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.data == data) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("不存在该节点");
        }
    }
}

/**
 * 双向链表节点类
 */
class Node2 {
    public int data;
    public Node2 next;
    public Node2 pre;

    public Node2(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "" + data;
    }
}