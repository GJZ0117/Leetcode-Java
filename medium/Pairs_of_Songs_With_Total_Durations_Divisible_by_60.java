package medium;

/**
 * 1010. Pairs of Songs With Total Durations Divisible by 60
 */

public class Pairs_of_Songs_With_Total_Durations_Divisible_by_60 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] arr = new int[60];
        int res = 0;
        for (int n : time) {
            res += arr[(60 - n % 60) % 60];
            arr[n % 60]++;
        }
        return res;
    }
}
