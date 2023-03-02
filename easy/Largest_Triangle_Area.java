package easy;

/**
 * 812. Largest Triangle Area
 */

public class Largest_Triangle_Area {
    public double largestTriangleArea(int[][] points) {
        double res = 0;
        for (int i = 0; i < points.length - 2; i++) {
            for (int j = i + 1; j < points.length - 1; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    int[] p1 = points[i];
                    int[] p2 = points[j];
                    int[] p3 = points[k];
                    int x1 = p1[0];
                    int y1 = p1[1];
                    int x2 = p2[0];
                    int y2 = p2[1];
                    int x3 = p3[0];
                    int y3 = p3[1];
                    res = Math.max(res, 0.5 * Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)));
                }
            }
        }
        return res;
    }
}
