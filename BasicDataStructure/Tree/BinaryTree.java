package BasicDataStructure.Tree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * 二叉树创建、遍历
 */

public class BinaryTree {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //测试数据:1 2 4 -1 -1 5 -1 -1 3 6 -1 -1 7 -1 -1
        Node root = createTree();

        //递归遍历
        System.out.println("\n先序遍历:");
        preOrder(root);
        System.out.println("\n中序遍历:");
        inOrder(root);
        System.out.println("\n后序遍历:");
        postOrder(root);

        //非递归遍历
        System.out.println("\n非递归先序遍历:");
        preOrderNonRecursion(root);
        System.out.println("\n非递归中序遍历:");
        inOrderNonRecursion(root);
        System.out.println("\n非递归后序遍历:");
        postOrderNonRecursion(root);

        //层次遍历
        System.out.println("\n层次遍历:");
        level(root);

        //二叉树高度
        System.out.println("\n二叉树高度为: " + height(root));
        //二叉树宽度
        System.out.println("二叉树宽度为: " + width(root));

        //查找节点
        Node p = new Node();
        p = null;
        System.out.print("输入要查询的节点的值: ");
        int key = sc.nextInt();
        p = search(root, key);
        if (p != null) {
            System.out.println("成功查到节点值为 " + key + " 的节点");
        } else {
            System.out.println("不存在节点值为 " + key + " 的节点");
        }

    }


    //递归创建二叉树
    public static Node createTree() {
        System.out.print("请输入节点的数据:");
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        } else {
            Node root = new Node();
            root.data = data;
            root.left = createTree();
            root.right = createTree();
            return root;
        }
    }

    //先序、中序、后序遍历（递归）
    public static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public static void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }


    //非递归前序、中序、后续遍历
    public static void preOrderNonRecursion(Node root) {
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            Node p;
            stack.push(root);
            while (!stack.isEmpty()) {
                p = stack.pop();
                System.out.print(p.data + " ");
                if (p.right != null) {
                    stack.push(p.right);
                }
                if (p.left != null) {
                    stack.push(p.left);
                }
            }
        }
    }

    public static void inOrderNonRecursion(Node root) {
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            Node p = root;
            while ((!stack.isEmpty()) || p != null) {
                while (p != null) {
                    stack.push(p);
                    p = p.left;
                }
                if (!stack.isEmpty()) {
                    p = stack.pop();
                    System.out.print(p.data + " ");
                    p = p.right;
                }
            }
        }
    }

    public static void postOrderNonRecursion(Node root) {
        if (root != null) {
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            Node p = null;
            stack1.push(root);
            while (!stack1.isEmpty()) {
                p = stack1.pop();
                stack2.push(p);
                if (p.left != null) {
                    stack1.push(p.left);
                }
                if (p.right != null) {
                    stack1.push(p.right);
                }
            }
            while (!stack2.isEmpty()) {
                p = stack2.pop();
                System.out.print(p.data + " ");
            }
        }
    }

    //层次遍历
    public static void level(Node root) {
        Queue<Node> queue = new LinkedList<>();
        Node p;
        if (root != null) {
            queue.add(root);
            while (!queue.isEmpty()) {
                p = queue.poll();
                System.out.print(p.data + " ");
                if (p.left != null) {
                    queue.add(p.left);
                }
                if (p.right != null) {
                    queue.add(p.right);
                }
            }
        }
    }

    //求二叉树高度
    public static int height(Node root) {
        int LD, RD;
        if (root == null) {
            return 0;
        } else {
            LD = height(root.left);
            RD = height(root.right);
            return (LD > RD ? LD : RD) + 1;
        }
    }

    //二叉树宽度
    public static int width(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int len;
        int width = 1; //非空时第一层有一个节点
        Node p;
        while (!queue.isEmpty()) {
            len = queue.size(); //某层节点数
            while (len > 0) {
                p = queue.poll();
                if (p.left != null) {
                    queue.add(p.left);
                }
                if (p.right != null) {
                    queue.add(p.right);
                }
                len--;
            }
            width = Math.max(width, queue.size());
        }
        return width;
    }

    //查找节点
    public static Node search(Node root, int key) {
        if (root != null) {
            if (root.data == key) {
                return root;
            } else {
                Node L = search(root.left, key);
                if (L != null) {
                    return L;
                }
                Node R = search(root.right, key);
                if (R != null) {
                    return R;
                }
            }
        }
        return null;
    }
}

class Node implements Comparable<Node>{
    Node left;
    Node right;
    int data;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }

    @Override
    public int compareTo(Node o) { //表示从小到大排序
        return this.data-o.data;
    }
}