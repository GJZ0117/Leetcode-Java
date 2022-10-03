package BasicDataStructure.Sort;

import java.util.Arrays;


/**
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[16];
        for (int i = 0; i < 16; i++) {
            arr[i] = (int) (Math.random() * 16);
        }
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int high) {
        int temp;
        int i = low, j = high;

        if (low < high) {
            temp = arr[low];

            while (i < j) { //将数组中小于temp的关键字放在左边，大于temp的关键字放在右边
                while (j > i && arr[j] >= temp) {
                    j -= 1;
                }
                if (i < j) {
                    arr[i] = arr[j];
                    i++;
                }

                while (i < j && arr[i] < temp) {
                    i += 1;
                }
                if (i < j) {
                    arr[j] = arr[i];
                    j -= 1;
                }
            }

            arr[i] = temp;
            quickSort(arr, low, i - 1);
            quickSort(arr, i + 1, high);
        }
    }

}
