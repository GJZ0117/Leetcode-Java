package medium;

import java.util.Arrays;

/**
 * 948. Bag of Tokens
 */

public class Bag_of_Tokens {
    public int bagOfTokensScore(int[] tokens, int power) {
        if (tokens.length == 0) {
            return 0;
        }
        Arrays.sort(tokens);
        int left = 0;
        int right = tokens.length - 1;
        int res = 0;
        while (left < right) {
            if (power >= tokens[left]) {
                power -= tokens[left++];
                res++;
            } else if (res > 0) {
                power += tokens[right--];
                res--;
            } else {
                break;
            }
        }
        if (left < tokens.length && power >= tokens[left]) {
            power -= tokens[left++];
            res++;
        }
        return res;
    }
}
