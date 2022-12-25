package easy;

/**
 * 661. Image Smoother
 */

public class Image_Smoother {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                int count = 0;
                for (int row = i - 1; row <= i + 1; row++) {
                    if (row < 0 || row >= m) {
                        continue;
                    }
                    for (int col = j - 1; col <= j + 1; col++) {
                        if (col < 0 || col >= n) {
                            continue;
                        }
                        sum += img[row][col];
                        count++;
                    }
                }
                ans[i][j] = sum / count;
            }
        }
        return ans;
    }
}
