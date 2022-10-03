package BasicDataStructure.Queue;

/**
 * 数组模拟队列
 */
public class ArrayQueue {
    private int maxSize; //数组最大容量
    private int front; //队头
    private int rear; //队尾
    private int[] arr; //存放数据的数组

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1; //front指向队列头的前一个位置
        rear = -1; //rear指向最后一个数据
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == front - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加元素
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    //出队
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        front++;
        return arr[front];
    }

    // 显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空的，没有数据~~");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }
}
