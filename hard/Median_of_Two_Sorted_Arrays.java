package hard;

/**
 * 4. Median of Two Sorted Arrays
 * https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2471/Very-concise-O(log(min(MN)))-iterative-solution-with-detailed-explanation
 */

public class Median_of_Two_Sorted_Arrays {

    public static void main(String[] args) {
        int[] nums1 = {0, 1, 2, 3};
        int[] nums2 = {1, 4, 5, 6, 7};

        System.out.println(findMedianSortedArrays(nums1, nums2));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int N1 = nums1.length;
        int N2 = nums2.length;
        if (N1 < N2) return findMedianSortedArrays(nums2, nums1);

        double INT_MIN = -99999999, INT_MAX = 99999999;

        int low = 0, high = 2 * N2;
        while (low <= high) {
            int mid2 = (low + high) / 2;
            int mid1 = N1 + N2  - mid2;

            double L1 = (mid1 == 0) ? INT_MIN : nums1[(mid1-1)/2];
            double L2 = (mid2 == 0) ? INT_MIN : nums2[(mid2-1)/2];
            double R1 = (mid1 == N1 * 2) ? INT_MAX : nums1[(mid1)/2];
            double R2 = (mid2 == N2 * 2) ? INT_MAX : nums2[(mid2)/2];

            if (L1 > R2) low = mid2 + 1;
            else if (L2 > R1) high = mid2 - 1;	// A2's lower half too big; need to move C2 left.
            else return (Math.max(L1,L2) + Math.min(R1, R2)) / 2;	// Otherwise, that's the right cut.
        }
        return -1;
    }
}
