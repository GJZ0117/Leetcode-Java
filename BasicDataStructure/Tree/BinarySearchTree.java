package BasicDataStructure.Tree;

import java.util.Scanner;

public class BinarySearchTree {
    public static Node root;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //创建
        while (true) {
            System.out.print("输入节点值: ");
            int key = sc.nextInt();
            if (key == -1) {
                break;
            }
            insert(key);
        }
        //层次遍历
        BinaryTree.level(root);
        //搜索
        System.out.print("\n输入要查询的key值: ");
        int key = sc.nextInt();
        Node p = search(key);
        if (p != null) {
            System.out.println("成功查询到值为 " + p.data + " 的节点");
        } else {
            System.out.println("不存在值为 " + key + " 的节点");
        }
    }

    //二叉搜索树的插入
    public static void insert(int key) {
        if (root == null) {
            root = new Node();
            root.data = key;
            root.left = null;
            root.right = null;
            return;
        }
        Node p = root;
        Node parent = null; //parent为p的父节点
        while (true) {
            if (p == null) { //找到了合适的位置
                Node temp = new Node();
                temp.data = key;
                temp.left = null;
                temp.right = null;
                if (parent.data < key) {
                    parent.right = temp;
                } else {
                    parent.left = temp;
                }
                return;
            }

            if (key < p.data) {
                parent = p;
                p = p.left;
            } else if (key > p.data) {
                parent = p;
                p = p.right;
            } else {
                System.out.println("已存在值为 " + key + "的节点");
                break;
            }
        }
    }

    //二叉搜索树的查询
    public static Node search(int key) {
        Node p = root;
        while (p != null) {
            if (key < p.data) {
                p = p.left;
            } else if (key > p.data) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }
}
