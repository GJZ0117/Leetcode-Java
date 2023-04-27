package medium;

/**
 * 852. Peak Index in a Mountain Array
 */

public class Peak_Index_in_a_Mountain_Array {
    public int peakIndexInMountainArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}
