package easy;

/**
 * 292. Nim Game
 */

public class Nim_Game {
    public boolean canWinNim(int n) {
        return !(n % 4 == 0);
    }
}
