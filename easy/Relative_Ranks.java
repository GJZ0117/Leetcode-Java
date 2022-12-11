package easy;

import java.util.PriorityQueue;

/**
 * 506. Relative Ranks
 */

public class Relative_Ranks {
    public String[] findRelativeRanks(int[] score) {
        String[] ans = new String[score.length];
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> score[b] - score[a]);
        int place = 1;
        for (int i = 0; i < score.length; i++) {
            heap.offer(i);
        }
        while (!heap.isEmpty()) {
            int curPos = heap.poll();
            if (place == 1) {
                ans[curPos] = "Gold Medal";
            } else if (place == 2) {
                ans[curPos] = "Silver Medal";
            } else if (place == 3) {
                ans[curPos] = "Bronze Medal";
            } else {
                ans[curPos] = String.valueOf(place);
            }
            place++;
        }
        return ans;
    }
}
