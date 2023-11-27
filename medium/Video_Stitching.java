package medium;

import java.util.Arrays;

/**
 * 1024. Video Stitching
 */

public class Video_Stitching {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, (a, b) -> a[0] - b[0]);
        int n = clips.length;
        int curEnd = 0;
        int farCanReach = 0;
        int total = 0;
        int i = 0;
        while (curEnd < time) {
            total++;
            while (i < n && curEnd >= clips[i][0]) {
                farCanReach = Math.max(farCanReach, clips[i++][1]);
            }
            if (farCanReach == curEnd) {
                return -1;
            }
            curEnd = farCanReach;
        }
        return total;
    }
}
