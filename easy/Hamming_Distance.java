package easy;

/**
 * 461. Hamming Distance
 */

public class Hamming_Distance {

    public static void main(String[] args) {
        int x = 1;
        int y = 4;
        System.out.println(hammingDistance(x, y));
    }

    public static int hammingDistance(int x, int y) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int bit1 = 1 & (x >> i);
            int bit2 = 1 & (y >> i);
            ans += bit1 == bit2 ? 0 : 1;
        }
        return ans;
    }
}
