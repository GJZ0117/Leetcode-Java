package easy;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 590. N-ary Tree Postorder Traversal
 */

public class N_ary_Tree_Postorder_Traversal {

    public List<Integer> postorder(NaryNode root) {
        List<Integer> list = new ArrayList<>();
        postOrderTraverse(root, list);
        return list;
    }

    public void postOrderTraverse(NaryNode cur, List<Integer> list) {
        if (cur != null) {
            for (NaryNode child : cur.children) {
                postOrderTraverse(child, list);
            }
            list.add(cur.val);
        }
    }


    public List<Integer> _postorder(NaryNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<NaryNode> stack1 = new LinkedList<>();
        Deque<NaryNode> stack2 = new LinkedList<>();
        NaryNode p = null;
        stack1.push(root);
        while (!stack1.isEmpty()) {
            p = stack1.pop();
            stack2.push(p);
            for (NaryNode child : p.children) {
                stack1.push(child);
            }
        }
        while (!stack2.isEmpty()) {
            NaryNode node = stack2.pop();
            list.add(node.val);
        }
        return list;
    }
}
