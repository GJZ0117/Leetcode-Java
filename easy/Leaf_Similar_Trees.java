package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 872. Leaf-Similar Trees
 */

public class Leaf_Similar_Trees {

    int index = 0;

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();
        preOrderRoot1(root1, list);
        return preOrderRoot2(root2, list) && index == list.size();
    }

    public void preOrderRoot1(TreeNode root, List<Integer> list) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                list.add(root.val);
            } else {
                preOrderRoot1(root.left, list);
                preOrderRoot1(root.right, list);
            }
        }
    }

    public boolean preOrderRoot2(TreeNode root, List<Integer> list) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                if (index >= list.size() || root.val != list.get(index)) {
                    return false;
                } else {
                    index = index + 1;
                    return true;
                }
            } else {
                boolean left = preOrderRoot2(root.left, list);
                boolean right = preOrderRoot2(root.right, list);
                return left && right;
            }
        }
        return true;
    }
}
