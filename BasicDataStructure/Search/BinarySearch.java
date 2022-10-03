package BasicDataStructure.Search;


import java.util.List;

/**
 * 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1024, 1234};
        int resIndex = binarySearch(arr, 0, arr.length - 1, 1000); //1000为要查找的值
        System.out.println("resIndexList = " + resIndex);
    }

    private static int binarySearch(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) {
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }
}
