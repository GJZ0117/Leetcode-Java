package medium;

/**
 * 371. Sum of Two Integers
 */

public class Sum_of_Two_Integers {
    public int getSum(int a, int b) {
        int ans = 0;
        boolean isCarry = false;
        for (int i = 0; i < 32; i++) {
            int bit1 = (a >> i) & 1;
            int bit2 = (b >> i) & 1;
            if (bit1 == 1 && bit2 == 1) {
                ans |= ((isCarry ? 1 : 0) << i);
                isCarry = true;
            } else if (bit1 == 1 || bit2 == 1) {
                ans |= ((isCarry ? 0 : 1) << i);
            } else {
                ans |= ((isCarry ? 1 : 0) << i);
                isCarry = false;
            }
        }
        return ans;
    }
}
