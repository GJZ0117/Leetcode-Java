package medium;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 963. Minimum Area Rectangle II
 */

public class Minimum_Area_Rectangle_II {
    public double minAreaFreeRect(int[][] points) {
        int n = points.length;
        Point[] A = new Point[n];
        Set<Point> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            A[i] = new Point(points[i][0], points[i][1]);
            set.add(A[i]);
        }
        double ans = Double.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            Point p1 = A[i];
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    Point p2 = A[j];
                    for (int k = j + 1; k < n; k++) {
                        if (i != k) {
                            Point p3 = A[k];
                            Point p4 = new Point(p2.x + p3.x - p1.x, p2.y + p3.y - p1.y);
                            if (set.contains(p4)) {
                                int dot = ((p2.x - p1.x) * (p3.x - p1.x) + (p2.y - p1.y) * (p3.y - p1.y));
                                if (dot == 0) {
                                    double area = p1.distance(p2) * p1.distance(p3);
                                    ans = Math.min(ans, area);
                                }
                            }
                        }
                    }
                }
            }
        }
        return ans < Double.MAX_VALUE ? ans : 0;
    }
}
