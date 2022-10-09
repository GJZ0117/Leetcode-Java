package easy;

/**
 * 278. First Bad Version
 */

public class First_Bad_Version {
    public static boolean isBadVersion(int version) {
        return true;
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (isBadVersion(mid) == false) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
