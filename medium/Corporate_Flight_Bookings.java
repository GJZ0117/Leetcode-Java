package medium;

/**
 * 1109. Corporate Flight Bookings
 */

public class Corporate_Flight_Bookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        for (int[] booking : bookings) {
            int i = booking[0] - 1;
            int j = booking[1];
            int k = booking[2];
            nums[i] += k;
            if (j < nums.length) {
                nums[j] -= k;
            }
        }
        int[] ans = new int[n];
        ans[0] = nums[0];
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] + nums[i];
        }
        return ans;
    }
}
