package BasicDataStructure.LinkedList;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(3);
        Node n3 = new Node(2);
        Node n4 = new Node(5);
        Node n5 = new Node(4);

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(n1);
        singleLinkedList.add(n2);
        singleLinkedList.add(n3);
        singleLinkedList.add(n4);
        singleLinkedList.add(n5);

        singleLinkedList.list();

        singleLinkedList.del(1);
        singleLinkedList.list();
        singleLinkedList.del(4);
        singleLinkedList.list();
    }
}

/**
 * 单链表类
 */
class SingleLinkedList {
    //初始化头节点
    private Node head = new Node(-1);

    //添加节点
    public void add(Node node){
        Node temp = head;
        while (true) {
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }

    //删除节点
    public void del(int data){
        Node temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null){
                break;
            }
            if (temp.next.data == data){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next = temp.next.next;
        }else{
            System.out.println("节点不存在");
        }
    }

    //显示链表
    public void list(){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        Node temp = head.next;
        while (true){
            if (temp == null){
                System.out.println();
                break;
            }
            System.out.print(temp + " ");
            temp = temp.next;
        }
    }
}


/**
 * 一个节点
 */
class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "" + data;
    }
}