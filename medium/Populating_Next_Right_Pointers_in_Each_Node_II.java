package medium;

/**
 * 117. Populating Next Right Pointers in Each Node II
 */

public class Populating_Next_Right_Pointers_in_Each_Node_II {
    //https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/solution/bfsjie-jue-zui-hao-de-ji-bai-liao-100de-yong-hu-by/
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node cur = root;
        while (cur != null) {
            //regard next level's nodes as a link list
            Node newHead = new Node();
            Node pre = newHead;
            while (cur != null) {
                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }
            cur = newHead.next;
        }
        return root;
    }
}
