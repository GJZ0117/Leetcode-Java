package medium;

/**
 * 449. Serialize and Deserialize BST
 */

public class Serialize_and_Deserialize_BST {
    class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            inOrder(root, sb);
            sb.deleteCharAt(sb.length() - 1);
            sb.append("]");
            return sb.toString();
        }

        public void inOrder(TreeNode cur, StringBuilder sb) {
            if (cur != null) {
                sb.append(cur.val);
                sb.append(",");
                inOrder(cur.left, sb);
                inOrder(cur.right, sb);
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if ("".equals(data)) {
                return null;
            }
            String[] values = data.substring(1, data.length() - 1).split(",");
            return buildTree(values, 0, values.length - 1);
        }

        public TreeNode buildTree(String[] data, int start, int end) {
            if (start > end) {
                return null;
            }
            TreeNode node = new TreeNode();
            node.val = Integer.parseInt(data[start]);
            int firstLargerNodeIndex = end + 1;
            for (int i = start + 1; i <= end; i++) {
                if (Integer.parseInt(data[i]) > node.val) {
                    firstLargerNodeIndex = i;
                    break;
                }
            }
            node.left = buildTree(data, start + 1, firstLargerNodeIndex - 1);
            node.right = buildTree(data, firstLargerNodeIndex, end);
            return node;
        }
    }
}
