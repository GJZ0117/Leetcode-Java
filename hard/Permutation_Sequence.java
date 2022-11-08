package hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 60. Permutation Sequence
 */

public class Permutation_Sequence {

    public static void main(String[] args) {
        System.out.println(getPermutation(3, 3));
    }

    public static String getPermutation(int n, int k) {
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = i;
        }
        List<Integer> ans = new ArrayList<>();
        generate(ans, nums, n, 1);
        Collections.sort(ans);
        return String.valueOf(ans.get(k - 1));
    }

    public static void generate(List<Integer> ans, int[] nums, int n, int start) {
        if (start == n) {
            int tempNum = 0;
            for (int i = 1; i <= n; i++) {
                tempNum *= 10;
                tempNum += nums[i];
            }
            ans.add(tempNum);
            return;
        }
        for (int i = start; i <= n; i++) {
            swap(nums, start, i);
            generate(ans, nums, n, start + 1);
            swap(nums, start, i);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
