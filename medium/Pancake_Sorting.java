package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * 969. Pancake Sorting
 */

public class Pancake_Sorting {
    public List<Integer> pancakeSort(int[] arr) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int n : arr) {
            set.add(n);
        }
        List<Integer> ans = new ArrayList<>();
        int index = arr.length - 1;
        int maxIndex = 0;
        int maxNum = 0;
        while (index >= 1) {
            maxNum = set.last();
            set.remove(maxNum);
            for (int i = 0; i <= index; i++) {
                if (arr[i] == maxNum) {
                    maxIndex = i;
                    break;
                }
            }
            if (maxIndex == 0) {
                swap(arr, 0, index);
                ans.add(index + 1);
            } else {
                swap(arr, 0, maxIndex);
                ans.add(maxIndex + 1);
                swap(arr, 0, index);
                ans.add(index + 1);
            }
            index--;
        }
        return ans;
    }

    public void swap(int[] arr, int left, int right) {
        int temp;
        while (left <= right) {
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
