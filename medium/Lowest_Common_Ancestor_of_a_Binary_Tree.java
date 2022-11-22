package medium;

import java.util.LinkedList;
import java.util.List;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 */

public class Lowest_Common_Ancestor_of_a_Binary_Tree {

    //better solution
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) {
            return root;
        }
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = new LinkedList<>();
        List<TreeNode> pathQ = new LinkedList<>();
        fillPath(pathP, root, p);
        fillPath(pathQ, root, q);
        int minLen = Math.min(pathP.size(), pathQ.size());
        TreeNode LCA = root;
        for (int i = 1; i < minLen; i++) {
            if (pathP.get(i).val == pathQ.get(i).val) {
                LCA = pathP.get(i);
            } else {
                break;
            }
        }
        return LCA;
    }

    public boolean fillPath(List<TreeNode> path, TreeNode root, TreeNode target) {
        if (!path.isEmpty() && path.get(path.size() - 1).val == target.val) {
            return true;
        }
        path.add(root);
        if (root.val == target.val) {
            return true;
        }
        if (root.left != null) {
            boolean left = fillPath(path, root.left, target);
            if (left) {
                return true;
            }
        }
        if (root.right != null) {
            boolean right = fillPath(path, root.right, target);
            if (right) {
                return true;
            }
        }
        path.remove(path.size() - 1);
        return false;
    }

}
