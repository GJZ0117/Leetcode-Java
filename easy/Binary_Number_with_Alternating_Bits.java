package easy;

/**
 * 693. Binary Number with Alternating Bits
 */

public class Binary_Number_with_Alternating_Bits {
    public boolean hasAlternatingBits(int n) {
        boolean findFisrt = false;
        int preBit = 1;
        for (int i = 31; i >= 0; i--) {
            if (findFisrt) {
                int curBit = (n >> i) & 1;
                if (preBit == curBit) {
                    return false;
                } else {
                    preBit = curBit;
                }
            } else {
                findFisrt = (((n >> i) & 1) == 1);
            }
        }
        return true;
    }
}
