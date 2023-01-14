package medium;

/**
 * 498. Diagonal Traverse
 */

public class Diagonal_Traverse {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[m * n];
        int index = 0;

        boolean isReversed = false;
        for (int i = 0; i < m; i++) {
            int start = index;
            int x = i;
            int y = 0;
            while (x >= 0 && y < n) {
                ans[index++] = mat[x--][y++];
            }
            if (isReversed) {
                reverse(ans, start, index - 1);
            }
            isReversed = !isReversed;
        }

        for (int j = 1; j < n; j++) {
            int start = index;
            int x = m - 1;
            int y = j;
            while (x >= 0 && y < n) {
                ans[index++] = mat[x--][y++];
            }
            if (isReversed) {
                reverse(ans, start, index - 1);
            }
            isReversed = !isReversed;
        }

        return ans;
    }

    public void reverse(int[] ans, int start, int end) {
        while (start < end) {
            int temp = ans[start];
            ans[start] = ans[end];
            ans[end] = temp;
            start++;
            end--;
        }
    }
}
