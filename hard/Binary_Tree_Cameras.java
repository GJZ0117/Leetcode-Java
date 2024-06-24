package hard;

/**
 * 968. Binary Tree Cameras
 */

public class Binary_Tree_Cameras {

    /**
     * 利用贪心思想来确定每个结点的状态
     * 有三个状态:
     * 0=>这个结点待覆盖
     * 1=>这个结点已经覆盖
     * 2=>这个结点上安装了相机
     *
     * @param root
     * @return
     */

    int ans = 0;

    public int minCameraCover(TreeNode root) {
        if (lrd(root) == 0) {
            ans++;
        }
        return ans;
    }

    public int lrd(TreeNode node) {
        // 为保证摄像头数目最少，叶子节点不放摄像头，故node为null时设置其状态为已覆盖
        if (node == null) {
            return 1;
        }
        // 左右孩子一共有 00,01,02,11,12,22 这些状态
        int left = lrd(node.left);
        int right = lrd(node.right);
        // 00 01 02 状态：左右孩子只要有一个未被覆盖，node就需要放置摄像头
        if (left == 0 || right == 0) {
            ans++;
            return 2;
        }
        // 11状态：node需要被父节点的摄像头覆盖，设置node状态为0
        if (left == 1 && right == 1) {
            return 0;
        }
        // 12 22状态：node被儿子覆盖 设置node状态为1
        return 1; // left + right >= 3
    }
}
