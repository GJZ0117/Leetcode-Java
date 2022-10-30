package easy;

/**
 * 191. Number of 1 Bits
 */

public class Number_of_1_Bits {
    public int hammingWeight(int n) {
        int ans = 0;
        int temp;
        for (int i=0; i<32; i++) {
            temp = n & 1;
            n = n >> 1;
            if (temp == 1) {
                ans++;
            }
        }
        return ans;
    }
}
