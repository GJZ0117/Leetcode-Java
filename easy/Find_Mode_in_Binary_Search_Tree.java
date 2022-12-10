package easy;

import java.util.LinkedList;
import java.util.List;

/**
 * 501. Find Mode in Binary Search Tree
 */

public class Find_Mode_in_Binary_Search_Tree {

    private TreeNode pre = null;
    private int count = 0;
    private int maxCount = 0;
    List<Integer> list = new LinkedList<>();


    public int[] findMode(TreeNode root) {
        inOrder(root);
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public void inOrder(TreeNode cur) {
        if (cur != null) {
            inOrder(cur.left);

            if (pre == null) {
                count = 1;
            } else if (pre.val == cur.val) {
                count++;
            } else {
                count = 1;
            }
            pre = cur;
            if (count == maxCount) {
                list.add(cur.val);
            } else if (count > maxCount) {
                maxCount = count;
                list.clear();
                list.add(cur.val);
            }
            inOrder(cur.right);
        }
    }
}
