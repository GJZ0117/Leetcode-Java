package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 728. Self Dividing Numbers
 */

public class Self_Dividing_Numbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (check(i)) {
                list.add(i);
            }
        }
        return list;
    }

    public boolean check(int num) {
        int temp = num;
        while (temp > 0) {
            int n = temp % 10;
            temp /= 10;
            if (n == 0 && temp != 0) {
                return false;
            }
            if (num % n != 0) {
                return false;
            }
        }
        return true;
    }
}
