package medium;

/**
 * 769. Max Chunks To Make Sorted
 */

public class Max_Chunks_To_Make_Sorted {

    public static void main(String[] args) {
        int[] arr = {2,0,1};
        System.out.println(maxChunksToSorted(arr));
    }

    public static int maxChunksToSorted(int[] arr) {
        int ans = 0;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int curMinNumIndex = findMinNumIndex(arr, left, right);
            left = curMinNumIndex + 1;
            ans++;
        }
        return ans;
    }

    private static int findMinNumIndex(int[] arr, int left, int right) {
        int minNumIndex = left;
        int maxNumIndex = left;
        while (true) {
            for (int i = minNumIndex + 1; i <= right; i++) {
                if (arr[i] < arr[minNumIndex]) {
                    minNumIndex = i;
                }
            }
            for (int i = left + 1; i <= minNumIndex; i++) {
                if (arr[i] > arr[maxNumIndex]) {
                    maxNumIndex = i;
                }
            }

            boolean isFind = false;
            for (int i = minNumIndex + 1; i <= right; i++) {
                if (arr[i] > arr[minNumIndex] && arr[i] < arr[maxNumIndex]) {
                    minNumIndex = i;
                    isFind = true;
                }
            }
            if (!isFind) {
                break;
            }
        }
        return minNumIndex;
    }
}
