package easy;

/**
 * 868. Binary Gap
 */

public class Binary_Gap {
    public int binaryGap(int n) {
        int maxDistance = 0;
        int preIndex = -1;
        for (int i = 0; i <= 31; i++) {
            if (((n >> i) & 1) == 1) {
                if (preIndex == -1) {
                    preIndex = i;
                } else {
                    maxDistance = Math.max(maxDistance, i - preIndex);
                    preIndex = i;
                }
            }
        }
        return maxDistance;
    }
}
