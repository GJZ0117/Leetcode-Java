package BasicDataStructure.Sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[16];
        for (int i = 0; i < 16; i++) {
            arr[i] = (int) (Math.random() * 16);
        }
        System.out.println(Arrays.toString(arr));
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void shellSort(int[] arr) {
        int temp;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }
}
