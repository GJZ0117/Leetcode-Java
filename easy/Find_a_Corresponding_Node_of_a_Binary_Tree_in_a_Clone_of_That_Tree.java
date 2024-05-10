package easy;

/**
 * 1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree
 */

public class Find_a_Corresponding_Node_of_a_Binary_Tree_in_a_Clone_of_That_Tree {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        preOrder(cloned, target.val);
        return ans;
    }

    TreeNode ans = null;

    public void preOrder(TreeNode node, int target) {
        if (node == null || ans != null) {
            return;
        }
        if (node.val == target) {
            ans = node;
            return;
        }
        preOrder(node.left, target);
        preOrder(node.right, target);
    }
}
