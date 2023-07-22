package medium;

/**
 * 991. Broken Calculator
 */

public class Broken_Calculator {
    public int brokenCalc(int startValue, int target) {
        int count = 0;
        while (startValue < target) {
            if (target % 2 != 0) {
                target++;
            } else {
                target /= 2;
            }
            count++;
        }
        count += startValue - target;
        return count;
    }
}
