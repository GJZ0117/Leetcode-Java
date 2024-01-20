package medium;

/**
 * 357. Count Numbers with Unique Digits
 */

public class Count_Numbers_with_Unique_Digits {

    public static void main(String[] args) {
        for (int n = 0; n <= 8; n++) {
            System.out.println("ans : " + countNumbersWithUniqueDigits(n));
        }
    }

    public static int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 10;
        }

        int[] records = new int[n + 1];
        records[1] = 10;
        int tempAns = 9;
        int pre = 9;

        for (int i = 2; i <= n; i++) {
            if (i == 2) {
                tempAns = tempAns * 9;
                pre = 9;
            } else {
                tempAns = tempAns * (pre - 1);
                pre--;
            }
            records[i] = tempAns;
        }

        int ans = 0;
        for (int num : records) {
            ans = ans + num;
        }
        return ans;
    }


    // 二刷
    public int countNumbersWithUniqueDigits_2(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 10;
        }
        int ans = 10;
        int cur = 9;
        for (int i = 0; i < n - 1; i++) {
            cur *= 9 - i;
            ans += cur;
        }
        return ans;
    }
}
