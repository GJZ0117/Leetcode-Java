package medium;

/**
 * 738. Monotone Increasing Digits
 */

public class Monotone_Increasing_Digits {
    // https://leetcode.cn/problems/monotone-increasing-digits/solution/jian-dan-tan-xin-shou-ba-shou-jiao-xue-k-a0mp/
    public int monotoneIncreasingDigits(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        int max = -1;
        int index = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (max < arr[i]) {
                max = arr[i];
                index = i;
            }
            if (arr[i] > arr[i + 1]) {
                arr[index] -= 1;
                for (int j = index + 1; j < arr.length; j++) {
                    arr[j] = '9';
                }
                break;
            }
        }
        return Integer.parseInt(new String(arr));
    }
}
