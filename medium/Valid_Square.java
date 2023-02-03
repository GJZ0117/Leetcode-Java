package medium;

/**
 * 593. Valid Square
 */

public class Valid_Square {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return check(p1, p2, p3) && check(p1, p2, p4) && check(p1, p3, p4) && check(p2, p3, p4);
    }

    public boolean check(int[] p1, int[] p2, int[] p3) {
        int d1 = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
        int d2 = (p2[0] - p3[0]) * (p2[0] - p3[0]) + (p2[1] - p3[1]) * (p2[1] - p3[1]);
        int d3 = (p1[0] - p3[0]) * (p1[0] - p3[0]) + (p1[1] - p3[1]) * (p1[1] - p3[1]);
        return (d1 > d2 && d2 == d3 && d1 == d2 + d3) || (d2 > d3 && d1 == d3 && d2 == d1 + d3) || (d3 > d1 && d1 == d2 && d3 == d1 + d2);
    }
}
