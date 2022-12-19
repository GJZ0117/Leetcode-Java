package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N-ary Tree Level Order Traversal
 */

class NaryNode {
    public int val;
    public List<NaryNode> children;

    public NaryNode() {
    }

    public NaryNode(int _val) {
        val = _val;
    }

    public NaryNode(int _val, List<NaryNode> _children) {
        val = _val;
        children = _children;
    }
};

public class N_ary_Tree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(NaryNode root) {
        Queue<NaryNode> queue = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();
        NaryNode p;
        int len;
        if (root == null) {
            return lists;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            len = queue.size();
            List<Integer> list = new ArrayList<>();
            while (len > 0) {
                p = queue.poll();
                list.add(p.val);
                for (NaryNode child : p.children) {
                    queue.add(child);
                }
                len--;
            }
            lists.add(list);
        }
        return lists;
    }
}
