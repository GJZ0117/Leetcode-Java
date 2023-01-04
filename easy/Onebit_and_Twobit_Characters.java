package easy;

/**
 * 717. 1-bit and 2-bit Characters
 */

public class Onebit_and_Twobit_Characters {
    public boolean isOneBitCharacter(int[] bits) {
        int curBit = 1;
        int i = 0;
        while (i < bits.length) {
            if (bits[i] == 0) {
                curBit = 1;
                i++;
            } else if (bits[i] == 1) {
                curBit = 2;
                i += 2;
            }
        }
        return curBit == 1;
    }
}
