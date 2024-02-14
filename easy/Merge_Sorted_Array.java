package easy;

/**
 * 88. Merge Sorted Array
 */

public class Merge_Sorted_Array {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }


    // 二刷
    public void merge_2(int[] nums1, int m, int[] nums2, int n) {
        int[] ans = new int[m + n];
        int index = 0;
        int index1 = 0;
        int index2 = 0;
        while (index < m + n && index1 < m && index2 < n) {
            if (nums1[index1] < nums2[index2]) {
                ans[index] = nums1[index1];
                index1++;
            } else {
                ans[index] = nums2[index2];
                index2++;
            }
            index++;
        }
        while (index1 < m) {
            ans[index++] = nums1[index1++];
        }
        while (index2 < n) {
            ans[index++] = nums2[index2++];
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = ans[i];
        }
    }
}
