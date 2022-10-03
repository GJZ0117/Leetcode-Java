package BasicDataStructure.Sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = new int[16];
        for (int i = 0; i < 16; i++) {
            arr[i] = (int) (Math.random() * 16);
        }
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        int i, j, k;
        int temp;
        for (i = 0; i < arr.length; i++) {
            k = i;

            for (j = i + 1; j < arr.length; j++) { //从无序序列中挑出一个最小的关键字
                if (arr[k] > arr[j]) {
                    k = j;
                }
            }

            //完成最小关键字与无序序列第一个关键字的交换
            temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
        }
    }
}
