package BasicDataStructure.Sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[16];
        for (int i = 0; i < 16; i++) {
            arr[i] = (int) (Math.random() * 16);
        }
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {
        int i, j;
        int temp;//将待插入关键字暂存入temp
        for (i = 1; i < arr.length; i++) { //从待排关键字之前的关键字开始扫描，如果大于待排关键字，则后一位
            temp = arr[i];
            j = i - 1;
            while (j >= 0 && temp < arr[j]) {
                arr[j + 1] = arr[j];
                --j;
            }
            arr[j + 1] = temp; //找到插入位置，将temp中暂存的待排关键字插入
        }
    }
}
