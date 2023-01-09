package medium;

import java.util.Arrays;

/**
 * 473. Matchsticks to Square
 */

public class Matchsticks_to_Square {

    public static void main(String[] args) {
        int[] matchsticks = {13, 11, 1, 8, 6, 7, 8, 8, 6, 7, 8, 9, 8};
        System.out.println(makesquare(matchsticks));
    }

    public static boolean makesquare(int[] matchsticks) {
        Arrays.sort(matchsticks);
        int sum = 0;
        for (int n : matchsticks) {
            sum += n;
        }
        if (sum % 4 != 0) {
            return false;
        }

        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }
        int[] bucket = new int[4];
        return dfs(matchsticks, sum / 4, bucket, 0);
    }

    public static boolean dfs(int[] matchsticks, int len, int[] bucket, int index) {
        if (index == matchsticks.length) {
            return true;
        }

        for (int i = 0; i < 4; i++) {
            if (bucket[i] + matchsticks[index] > len) {
                continue;
            }

            bucket[i] += matchsticks[index];
            if (dfs(matchsticks, len, bucket, index + 1)) {
                return true;
            }
            bucket[i] -= matchsticks[index];

            if (bucket[i] == 0) {
                return false;
            }
        }
        return false;
    }
}
