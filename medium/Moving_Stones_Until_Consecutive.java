package medium;

/**
 * 1033. Moving Stones Until Consecutive
 */

public class Moving_Stones_Until_Consecutive {
    // https://leetcode.cn/problems/moving-stones-until-consecutive/solutions/2250643/fen-lei-tao-lun-pythonjavacgo-by-endless-2qyo/
    public int[] numMovesStones(int a, int b, int c) {
        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));
        int mid = a + b + c - max - min;
        int[] res = new int[2];
        if (max - min == 2) {
            res[0] = 0;
        } else if (mid - min == 1 || max - mid == 1) {
            res[0] = 1;
        } else if (mid - min == 2 || max - mid == 2) {
            res[0] = 1;
        } else {
            res[0] = 2;
        }
        res[1] = max - min - 2;
        return res;
    }
}
