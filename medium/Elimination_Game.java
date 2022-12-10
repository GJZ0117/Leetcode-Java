package medium;

/**
 * 390. Elimination Game
 */

public class Elimination_Game {

    //https://leetcode.cn/problems/elimination-game/solution/c-shu-xue-by-qian2-60yk/
    public int lastRemaining(int n) {
        int numAccount = n;
        int loopCount = 0;
        int a0 = 1;
        int d = 1;
        while (numAccount != 1) {
            if (numAccount % 2 == 1) {
                a0 = a0 + d;
            } else if (numAccount % 2 == 0) {
                boolean leftToRight = ((loopCount % 2) == 0);
                if (leftToRight) {
                    a0 = a0 + d;
                } else {
                    a0 = a0;
                }
            }
            loopCount++;
            d *= 2;
            numAccount /= 2;
        }
        return a0;
    }
}
