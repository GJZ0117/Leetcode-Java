package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 9. Palindrome Number
 */

public class Palindrome_Number {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x == 0) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        int cur;
        while (x > 0) {
            cur = x % 10;
            list.add(cur);
            x /= 10;
        }
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            if (list.get(i) != list.get(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    // 二刷
    public boolean isPalindrome_2(int x) {
        if (x < 0 || (x > 9 && x % 10 == 0)) {
            return false;
        }
        String str = String.valueOf(Math.abs(x));
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
