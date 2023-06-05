package medium;

import java.util.Arrays;

/**
 * 923. 3Sum With Multiplicity
 */

public class ThreeSum_With_Multiplicity {
    public int threeSumMulti(int[] arr, int target) {
        long MOD = (long) (1e9 + 7);
        Arrays.sort(arr);
        int n = arr.length;
        long res = 0;
        for (int i = 0; i < n - 2; i++) {
            int t = target - arr[i];
            if (t < 2 * arr[i]) {
                break;
            }
            int left = i + 1;
            int right = n - 1;
            while (arr[left] < arr[right]) {
                if (arr[left] + arr[right] > t) {
                    right--;
                } else if (arr[left] + arr[right] < t) {
                    left++;
                } else {
                    int tempLeft = left;
                    int tempRight = right;
                    while (arr[++left] == arr[tempLeft]) ;
                    while (arr[--right] == arr[tempRight]) ;
                    res += (left - tempLeft) * (tempRight - right);
                    res %= MOD;
                }
            }
            if (arr[left] == arr[right] && arr[left] + arr[right] == t) {
                int d = right - left + 1;
                res += d * (d - 1) / 2;
                res %= MOD;
            }
        }
        return (int) res;
    }
}
