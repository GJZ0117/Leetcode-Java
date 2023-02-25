package medium;

/**
 * 667. Beautiful Arrangement II
 */

public class Beautiful_Arrangement_II {
    // https://leetcode.cn/problems/beautiful-arrangement-ii/solution/you-by-capital-worker-rnwi/
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int i = 0;
        int p = 1;
        int q = n;
        for (int j = 0; j < k; j++) {
            if (j % 2 == 0) {
                ans[i++] = p++;
            } else {
                ans[i++] = q--;
            }
        }
        if (k % 2 == 0) {
            while (i < n) {
                ans[i++] = q--;
            }
        } else {
            while (i < n) {
                ans[i++] = p++;
            }
        }
        return ans;
    }
}
