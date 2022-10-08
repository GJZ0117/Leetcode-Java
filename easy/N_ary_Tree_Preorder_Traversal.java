package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N-ary Tree Preorder Traversal
 */


class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class N_ary_Tree_Preorder_Traversal {
    public static List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        preOrderRecursion(root, list);
        return list;
    }

    public static void preOrderRecursion(Node root, List<Integer> list) {
        if (root != null){
            list.add(root.val);
            for (Node child : root.children) {
                if (child!=null){
                    preOrderRecursion(child, list);
                }
            }
        }
    }
}
