package medium;

import java.util.Arrays;

/**
 * 646. Maximum Length of Pair Chain
 */

public class Maximum_Length_of_Pair_Chain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int result = 0;
        int current = Integer.MIN_VALUE;
        for (int i = 0; i < pairs.length; i++) {
            if (pairs[i][0] > current) {
                current = pairs[i][1];
                result++;
            }
        }
        return result;
    }
}
