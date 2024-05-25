package easy;

import java.util.*;

/**
 * 559. Maximum Depth of N-ary Tree
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
}

public class Maximum_Depth_of_N_ary_Tree {
    public int maxDepth(NaryNode root) {
        if (root == null) {
            return 0;
        }
        Queue<NaryNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int len = queue.size();
            while (len > 0) {
                NaryNode p = queue.poll();
                while (!p.children.isEmpty()) {
                    queue.add(p.children.get(0));
                    p.children.remove(0);
                }
                len--;
            }
        }
        return depth;
    }


    // 二刷
    public int maxDepth_2(NaryNode root) {
        if (root == null) {
            return 0;
        }
        Deque<NaryNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int len = queue.size();
            while (len > 0) {
                NaryNode cur = queue.pollFirst();
                for (NaryNode node : cur.children) {
                    queue.addLast(node);
                }
                len--;
            }
        }
        return depth;
    }
}
