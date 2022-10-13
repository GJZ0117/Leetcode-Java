package easy;

/**
 * 69. Sqrt(x)
 */

public class Sqrt_x {

    public static void main(String[] args) {
        System.out.println(mySqrt(200000));
    }

    public static int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int left = 0;
        int right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                if ((mid + 1) > x / (mid + 1)) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            }
        }
    }
}
