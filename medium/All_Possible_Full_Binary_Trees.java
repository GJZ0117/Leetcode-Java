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


    // 二刷（还不会）
    // https://leetcode.cn/problems/all-possible-full-binary-trees/solutions/2719920/you-yi-dao-mo-ban-ti-dan-geng-ling-huo-x-j03j/?show=1
    public List<TreeNode> allPossibleFBT_2(int n) {
        return build(n);
    }

    public List<TreeNode> build(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        if (n % 2 == 0) {
            return res;
        }

        for (int i = 1; i < n; i += 2) {
            List<TreeNode> leftTree = build(i);
            List<TreeNode> rightTree = build(n - i - 1);
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode node = new TreeNode(0, left, right);
                    res.add(node);
                }
            }
        }
        return res;
    }
}
