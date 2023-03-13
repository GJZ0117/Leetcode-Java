package medium;

/**
 * 718. Maximum Length of Repeated Subarray
 */

public class Maximum_Length_of_Repeated_Subarray {
    public int findLength(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int maxLength = 0;
        int window = 1;
        boolean windowReachMax = false;
        while (window > 0) {
            int curMaxLength = 0;
            int n1Left = windowReachMax ? nums1.length - window : 0;
            int n2Left = windowReachMax ? 0 : nums2.length - window;
            int prev = 0;
            for (int i = 0; i < window; i++) {
                if (nums1[n1Left + i] == nums2[n2Left + i]) {
                    prev += 1;
                    curMaxLength = Math.max(curMaxLength, prev);
                } else {
                    prev = 0;
                }
            }
            maxLength = Math.max(maxLength, curMaxLength);
            if (window == nums1.length) {
                windowReachMax = true;
            }
            if (windowReachMax) {
                window--;
            } else {
                window++;
            }
        }
        return maxLength;
    }
}
