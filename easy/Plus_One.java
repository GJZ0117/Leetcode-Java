package easy;

import java.util.Arrays;

/**
 * 66. Plus One
 */

public class Plus_One {

    public static void main(String[] args) {
        int[] digits = {1,9};
        System.out.println(Arrays.toString(digits));
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    public static int[] plusOne(int[] digits) {
        digits[digits.length - 1]++;
        if (digits[digits.length - 1] != 10) {
            return digits;
        }

        boolean flag = true;
        for (int i = digits.length - 1; i >= 1; i--) {
            if (flag){
                digits[i] -= 10;
                digits[i-1] += 1;
                flag = digits[i - 1] == 10;
            }else {
                break;
            }
        }

        if (digits[0] == 10){
            int[] ans = new int[digits.length+1];
            ans[0] = 1;
            ans[1] = 0;
            for (int i=1; i<digits.length; i++) {
                ans[i+1] = digits[i];
            }
            return ans;
        }else {
            return digits;
        }
    }
}
