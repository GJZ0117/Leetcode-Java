package easy;

/**
 * 441. Arranging Coins
 */

public class Arranging_Coins {
    public int arrangeCoins(int n) {
        int stage = 0;
        int curLevelCoins = 1;
        while (n >= curLevelCoins) {
            n -= curLevelCoins;
            curLevelCoins++;
            stage++;
        }
        return stage;
    }
}
