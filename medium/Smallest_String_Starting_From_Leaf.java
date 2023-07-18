package medium;

/**
 * 988. Smallest String Starting From Leaf
 */

public class Smallest_String_Starting_From_Leaf {
    String res = "~";

    public String smallestFromLeaf(TreeNode root) {
        preOrder(root, new StringBuilder());
        return res;
    }

    public void preOrder(TreeNode node, StringBuilder sb) {
        if (node != null) {
            sb.insert(0, (char) ('a' + node.val));
            if (node.left == null && node.right == null) {
                String str = sb.toString();
                if (str.compareTo(res) < 0) {
                    res = str;
                }
            }
            preOrder(node.left, sb);
            preOrder(node.right, sb);
            sb.deleteCharAt(0);
        }
    }
}
