package easy;

import java.util.Arrays;

/**
 * 733. Flood Fill
 */

public class Flood_Fill {

    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        image = floodFill(image, 1, 1, 2);
        for (int[] nums : image) {
            System.out.println(Arrays.toString(nums));
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int[][] temp = new int[m][n];
        int target = image[sr][sc];
        generate(image, sr, sc, color, target, temp);
        return image;
    }

    public static void generate(int[][] image, int sr, int sc, int color, int target, int[][] temp) {
        temp[sr][sc] = 1;
        image[sr][sc] = color;
        if (sr - 1 >= 0 && temp[sr - 1][sc] == 0 && image[sr - 1][sc] == target) {
            generate(image, sr - 1, sc, color, target, temp);
        }
        if (sr + 1 < image.length && temp[sr + 1][sc] == 0 && image[sr + 1][sc] == target) {
            generate(image, sr + 1, sc, color, target, temp);
        }
        if (sc - 1 >= 0 && temp[sr][sc - 1] == 0 && image[sr][sc - 1] == target) {
            generate(image, sr, sc - 1, color, target, temp);
        }
        if (sc + 1 < image[0].length && temp[sr][sc + 1] == 0 && image[sr][sc + 1] == target) {
            generate(image, sr, sc + 1, color, target, temp);
        }
    }
}
