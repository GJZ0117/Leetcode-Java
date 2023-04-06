package easy;

/**
 * 941. Valid Mountain Array
 */

public class Valid_Mountain_Array {
    public boolean validMountainArray(int[] arr) {
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            maxIndex = arr[i] > arr[maxIndex] ? i : maxIndex;
        }
        if (maxIndex == 0 || maxIndex == arr.length - 1) {
            return false;
        }
        for (int i = 0; i < maxIndex; i++) {
            if (arr[i] >= arr[i + 1]) {
                return false;
            }
        }
        for (int i = maxIndex; i < arr.length - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
