package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 129. Sum Root to Leaf Numbers
 */

public class Sum_Root_to_Leaf_Numbers {
    public int sumNumbers(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        List<Integer> nums = new ArrayList<>();
        search(nums, new ArrayList<>(), root);
        int ans = 0;
        for (int num : nums) {
            ans += num;
        }
        return ans;
    }

    public void search(List<Integer> nums, List<Integer> list, TreeNode root) {
        list.add(root.val);
        if (root.left == null && root.right == null) {
            int num = 0;
            for (int n : list) {
                num *= 10;
                num += n;
            }
            nums.add(num);
            list.remove(list.size() - 1);
            return;
        }
        if (root.left != null) {
            search(nums, list, root.left);
        }
        if (root.right != null) {
            search(nums, list, root.right);
        }
        list.remove(list.size() - 1);
    }
}
