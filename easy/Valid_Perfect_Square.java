package easy;

/**
 * 367. Valid Perfect Square
 */

public class Valid_Perfect_Square {
    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == 1.0 * num / mid) {
                return true;
            } else if (mid < 1.0 * num / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
