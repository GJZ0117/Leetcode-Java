package medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 222. Count Complete Tree Nodes
 */

public class Count_Complete_Tree_Nodes {

    public int betterSolution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (left == right) {
            return betterSolution(root.right) + (int) Math.pow(2, left);
        } else {
            return betterSolution(root.left) + (int) Math.pow(2, right);
        }
    }

    public int height(TreeNode root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.left;
        }
        return height;
    }

    //----------------------------------------

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int height = 0;
        int queueSize = 1;
        boolean findWithoutTwoChildren = false;
        while (!queue.isEmpty() && !findWithoutTwoChildren) {
            height++;
            queueSize = queue.size();
            while (queueSize > 0) {
                TreeNode node = queue.poll();
                queueSize--;
                if (node.left != null) {
                    queue.add(node.left);
                } else {
                    findWithoutTwoChildren = true;
                    break;
                }
                if (node.right != null) {
                    queue.add(node.right);
                } else {
                    findWithoutTwoChildren = true;
                    break;
                }
            }
        }
        int leftNodeNum = queue.size() - queueSize;
        return (int) Math.pow(2, height) - 1 + leftNodeNum;
    }
}
