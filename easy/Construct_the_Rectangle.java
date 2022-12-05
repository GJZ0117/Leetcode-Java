package easy;

/**
 * 492. Construct the Rectangle
 */

public class Construct_the_Rectangle {
    public int[] constructRectangle(int area) {
        int[] ans = {area, 1};
        int diff = area - 1;
        for (int i = 2; i <= area / 2; i++) {
            if (area % i == 0) {
                int L = Math.max(area / i, i);
                int W = Math.min(i, area / i);
                if (L - W < diff) {
                    diff = L - W;
                    ans[0] = L;
                    ans[1] = W;
                }
            }
        }
        return ans;
    }
}
