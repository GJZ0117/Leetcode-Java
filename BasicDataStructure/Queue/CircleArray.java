package BasicDataStructure.Queue;

/**
 * 数组模拟环形队列
 */
public class CircleArray {
    private int maxSize; //数组最大容量
    private int front = 0;
    private int rear = 0;
    private int[] arr;

    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    //判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加元素到队列
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    //出队
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //求当前队列有效数据
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }
}
