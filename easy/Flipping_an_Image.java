package easy;

/**
 * 832. Flipping an Image
 */

public class Flipping_an_Image {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int row = 0; row < image.length; row++) {
            int i = 0;
            int j = image[0].length - 1;
            while (i <= j) {
                int temp = image[row][i];
                image[row][i] = image[row][j];
                image[row][j] = temp;
                image[row][i] = 1 - image[row][i];
                if (i != j) {
                    image[row][j] = 1 - image[row][j];
                }
                i++;
                j--;
            }
        }
        return image;
    }
}
