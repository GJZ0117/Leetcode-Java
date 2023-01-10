package medium;

/**
 * 477. Total Hamming Distance
 */

public class Total_Hamming_Distance {
    public int totalHammingDistance(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 31; i++) {
            int count0 = 0;
            int count1 = 0;
            for (int num : nums) {
                if (((num >> i) & 1) == 1) {
                    count1++;
                } else {
                    count0++;
                }
            }
            ans += count0 * count1;
        }
        return ans;
    }
}
