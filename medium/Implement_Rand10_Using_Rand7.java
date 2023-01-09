package medium;

import java.util.Random;

/**
 * 470. Implement Rand10() Using Rand7()
 */

public class Implement_Rand10_Using_Rand7 {
    public int rand10() {
        int base1 = rand7();
        while (base1 == 7) {
            base1 = rand7();
        }
        base1 = base1 % 2;
        int base2 = rand7();
        while (base2 >= 6) {
            base2 = rand7();
        }
        return base2 + 5 * base1;
    }

    public int rand7() {
        Random random = new Random();
        return random.nextInt(7);
    }
}
