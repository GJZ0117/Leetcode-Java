package medium;

/**
 * 1014. Best Sightseeing Pair
 */

public class Best_Sightseeing_Pair {
    public int maxScoreSightseeingPair(int[] values) {
        // score = A[i] + A[j] + i - j = (A[i] + i) + (A[j] - j)
        int maxPre = values[0];
        int maxScore = 0;
        for (int i = 1; i < values.length; i++) {
            maxPre = Math.max(maxPre, values[i - 1] + i - 1);
            maxScore = Math.max(maxScore, maxPre + values[i] - i);
        }
        return maxScore;
    }
}
