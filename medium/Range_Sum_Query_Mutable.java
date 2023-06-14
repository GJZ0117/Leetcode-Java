package medium;

/**
 * 307. Range Sum Query - Mutable
 */

public class Range_Sum_Query_Mutable {
    // https://leetcode.cn/problems/range-sum-query-mutable/solution/xian-duan-shu-zu-shou-hui-tu-xiang-yi-qing-er-chu-/
    class NumArray {
        int[] tree;
        int n;

        public NumArray(int[] nums) {
            n = nums.length;
            tree = new int[2 * n];
            for (int i = n; i < 2 * n; i++) {
                tree[i] = nums[i - n];
            }
            for (int i = n - 1; i >= 0; i--) {
                tree[i] = tree[2 * i] + tree[2 * i + 1];
            }
        }

        public void update(int index, int val) {
            int pos = n + index;
            tree[pos] = val;
            while (pos > 0) {
                int left = pos % 2 == 0 ? pos : pos - 1;
                int right = pos % 2 == 0 ? pos + 1 : pos;
                tree[pos / 2] = tree[left] + tree[right];
                pos /= 2;
            }

        }

        public int sumRange(int left, int right) {
            int sum = 0;
            int l = n + left;
            int r = n + right;
            while (r >= l) {
                if (l % 2 == 1) {
                    sum += tree[l];
                    l++;
                }
                if (r % 2 == 0) {
                    sum += tree[r];
                    r--;
                }
                l /= 2;
                r /= 2;
            }
            return sum;
        }
    }
}
