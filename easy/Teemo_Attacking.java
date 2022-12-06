package easy;

/**
 * 495. Teemo Attacking
 */

public class Teemo_Attacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int time = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            int cur = timeSeries[i];
            int next = timeSeries[i + 1];
            if (next - cur >= duration) {
                time += duration;
            } else {
                time += (next - cur);
            }
        }
        return time + duration;
    }
}
