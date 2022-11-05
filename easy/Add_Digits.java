package easy;

/**
 * 258. Add Digits
 */

public class Add_Digits {
    public int addDigits(int num) {
        while (num >= 10) {
            int temp = 0;
            while (num != 0) {
                temp += num % 10;
                num /= 10;
            }
            num = temp;
        }
        return num;
    }
}
