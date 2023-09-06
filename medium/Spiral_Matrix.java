package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 */

public class Spiral_Matrix {

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(spiralOrder(nums));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] temp = new int[m][n];
        int totalNum = m * n;

        int i = 0;
        int j = 0;

        while (totalNum > 0) {
            while (j < n && temp[i][j] != 1) {
                ans.add(matrix[i][j]);
                temp[i][j] = 1;
                totalNum--;
                j++;
            }
            j--;
            i++;
            while (i < m && temp[i][j] != 1) {
                ans.add(matrix[i][j]);
                temp[i][j] = 1;
                totalNum--;
                i++;
            }
            i--;
            j--;
            while (j >= 0 && temp[i][j] != 1) {
                ans.add(matrix[i][j]);
                temp[i][j] = 1;
                totalNum--;
                j--;
            }
            j++;
            i--;
            while (i >= 0 && temp[i][j] != 1) {
                ans.add(matrix[i][j]);
                temp[i][j] = 1;
                totalNum--;
                i--;
            }
            i++;
            j++;
        }

        return ans;
    }


    // 二刷
    public List<Integer> spiralOrder_2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int total = m * n;
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>(m * n);
        while (total > 0) {
            while (j < n && !visited[i][j]) {
                list.add(matrix[i][j]);
                visited[i][j] = true;
                j++;
                total--;
            }
            i++;
            j--;

            while (i < m && !visited[i][j]) {
                list.add(matrix[i][j]);
                visited[i][j] = true;
                i++;
                total--;
            }
            i--;
            j--;

            while (j >= 0 && !visited[i][j]) {
                list.add(matrix[i][j]);
                visited[i][j] = true;
                j--;
                total--;
            }
            i--;
            j++;

            while (i >= 0 && !visited[i][j]) {
                list.add(matrix[i][j]);
                visited[i][j] = true;
                i--;
                total--;
            }
            i++;
            j++;
        }
        return list;
    }

}
