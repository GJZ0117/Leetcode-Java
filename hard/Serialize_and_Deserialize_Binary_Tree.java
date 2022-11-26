package hard;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 297. Serialize and Deserialize Binary Tree
 */

public class Serialize_and_Deserialize_Binary_Tree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val);
                queue.add(node.left);
                queue.add(node.right);
            } else {
                sb.append("null");
            }
            sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        data = data.substring(1, data.length() - 1);
        String[] nodeStrings = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodeStrings[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!"null".equals(nodeStrings[index])) {
                node.left = new TreeNode(Integer.parseInt(nodeStrings[index]));
                queue.add(node.left);
            }
            index++;
            if (!"null".equals(nodeStrings[index])) {
                node.right = new TreeNode(Integer.parseInt(nodeStrings[index]));
                queue.add(node.right);
            }
            index++;
        }
        return root;
    }
}
