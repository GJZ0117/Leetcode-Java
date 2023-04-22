package medium;

/**
 * 845. Longest Mountain in Array
 */

public class Longest_Mountain_in_Array {
    public int longestMountain(int[] arr) {
        int ans = 0;
        int start = -1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i]) {
                if (start == -1 || arr[i - 2] >= arr[i - 1]) {
                    start = i - 1;
                }
            } else if (arr[i - 1] > arr[i]) {
                if (start != -1) {
                    ans = Math.max(ans, i - start + 1);
                }
            } else {
                start = -1;
            }
        }
        return ans;
    }
}
