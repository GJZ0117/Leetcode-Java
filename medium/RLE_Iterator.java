package medium;

/**
 * 900. RLE Iterator
 */

public class RLE_Iterator {
    class RLEIterator {
        int[][] memo;
        int startIndex;

        public RLEIterator(int[] encoding) {
            memo = new int[encoding.length / 2][2];
            startIndex = 0;
            for (int i = 0; i < encoding.length; i += 2) {
                memo[i / 2][0] = encoding[i + 1];
                memo[i / 2][1] = encoding[i];
            }
        }

        public int next(int n) {
            while (startIndex < memo.length) {
                if (n < memo[startIndex][1]) {
                    memo[startIndex][1] -= n;
                    return memo[startIndex][0];
                } else if (n == memo[startIndex][1]) {
                    memo[startIndex][1] = 0;
                    startIndex++;
                    return memo[startIndex - 1][0];
                } else if (n > memo[startIndex][1]) {
                    n -= memo[startIndex][1];
                    memo[startIndex][1] = 0;
                    startIndex++;
                }
            }
            return -1;
        }
    }
}
