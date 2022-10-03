package BasicDataStructure.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 哈夫曼树
 */

public class HuffmanTree {

    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node root = createHuffmanTree(arr);
        System.out.print("层次遍历哈夫曼树: ");
        BinaryTree.level(root);
    }

    public static Node createHuffmanTree(int[] arr) {
        List<Node> nodes = new ArrayList<>();
        for (int key : arr) {
            nodes.add(new Node(key));
        }
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node leftNode = nodes.get(0); //取出权值最小的节点
            Node rightNode = nodes.get(1); //取出权值第二小的节点
            Node parent = new Node(leftNode.data + rightNode.data); //构建一棵新的二叉树
            parent.left = leftNode;
            parent.right = rightNode;
            nodes.remove(leftNode);//删除处理过的二叉树
            nodes.remove(rightNode);
            nodes.add(parent); //将parent加入到nodes
        }
        return nodes.get(0);
    }
}
