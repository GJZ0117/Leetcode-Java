package easy;

/**
 * 762. Prime Number of Set Bits in Binary Representation
 */

public class Prime_Number_of_Set_Bits_in_Binary_Representation {
    public int countPrimeSetBits(int left, int right) {
        int[] primes = {0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0};
        int ans = 0;
        for (int i = left; i <= right; i++) {
            int bitsNum = Integer.bitCount(i);
            ans += primes[bitsNum];
        }
        return ans;
    }
}
