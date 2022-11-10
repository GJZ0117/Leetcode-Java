package easy;

import java.util.Arrays;

/**
 * 338. Counting Bits
 */

public class Counting_Bits {

    public static void main(String[] args) {
        Counting_Bits solution = new Counting_Bits();
        System.out.println(Arrays.toString(solution.countBits(5)));
    }

    public int[] countBits(int n) {
        int[] ones = new int[n + 1];
        ones[0] = 0;
        if (n == 0) {
            return ones;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(0);

        for (int i = 1; i <= n; i++) {
            addOne(sb);
            ones[i] = countOne(sb);
        }
        return ones;
    }

    public void addOne(StringBuilder sb) {
        char lastChar = sb.charAt(sb.length() - 1);
        boolean flag = (lastChar == '1');
        if (flag) {
            int index = sb.length() - 1;
            while (index >= 0 && flag) {
                int curNum = sb.charAt(index);
                if (curNum == '0') {
                    sb.replace(index, index + 1, "1");
                    flag = false;
                    index--;
                } else if (curNum == '1') {
                    sb.replace(index, index + 1, "0");
                    index--;
                }
            }
            if (flag) {
                sb.insert(0, "1");
            }
        } else {
            sb.replace(sb.length() - 1, sb.length(), "1");
        }
    }

    public int countOne(StringBuilder sb) {
        int ans = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '1') {
                ans++;
            }
        }
        return ans;
    }
}
