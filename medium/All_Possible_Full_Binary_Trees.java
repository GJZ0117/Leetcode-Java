package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 894. All Possible Full Binary Trees
 */

public class All_Possible_Full_Binary_Trees {
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> list = new ArrayList<>();
        if (n % 2 == 0) {
            return list;
        } else if (n == 1) {
            list.add(new TreeNode(0));
            return list;
        }
        int leftChlidNum = 1;
        int rightChildNum = n - 2;
        while (rightChildNum > 0) {
            List<TreeNode> leftChild = allPossibleFBT(leftChlidNum);
            List<TreeNode> rightChild = allPossibleFBT(rightChildNum);
            for (TreeNode l : leftChild) {
                for (TreeNode r : rightChild) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
            rightChildNum -= 2;
            leftChlidNum += 2;
        }
        return list;
    }
}
