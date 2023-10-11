package medium;

import java.util.*;

/**
 * 102. Binary Tree Level Order Traversal
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Binary_Tree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        List<TreeNode> queue = new ArrayList<>(); //队列用于层次遍历二叉树保存节点
        queue.add(root);
        int len; //记录每一层节点个数
        TreeNode p;

        while (!queue.isEmpty()) {
            len = queue.size(); //某层节点数
            List<Integer> tempList = new ArrayList<>(); //保存每层节点的数值
            while (len > 0) {
                p = queue.get(0);
                tempList.add(p.val);
                queue.remove(0);
                if (p.left != null) {
                    queue.add(p.left);
                }
                if (p.right != null) {
                    queue.add(p.right);
                }
                len--;
            }
            list.add(tempList);
        }

        return list;
    }


    // 二刷
    public List<List<Integer>> levelOrder_2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        int len;
        TreeNode p;
        while (!deque.isEmpty()) {
            len = deque.size();
            while (len > 0) {
                p = deque.removeFirst();
                list.add(p.val);
                if (p.left != null) {
                    deque.addLast(p.left);
                }
                if (p.right != null) {
                    deque.addLast(p.right);
                }
                len--;
            }
            res.add(new ArrayList<>(list));
            list.clear();
        }
        return res;
    }
}
