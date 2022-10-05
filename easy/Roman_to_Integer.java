package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. Roman to Integer
 */

public class Roman_to_Integer {

    public static void main(String[] args) {
            String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int ans = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'I') {
                if (i != chars.length - 1 && chars[i + 1] == 'V') {
                    ans += 4;
                    i++;
                } else if (i != chars.length - 1 && chars[i + 1] == 'X') {
                    ans += 9;
                    i++;
                } else {
                    ans += map.get('I');
                }
            } else if (chars[i] == 'X') {
                if (i != chars.length - 1 && chars[i + 1] == 'L') {
                    ans += 40;
                    i++;
                } else if (i != chars.length - 1 && chars[i + 1] == 'C') {
                    ans += 90;
                    i++;
                } else {
                    ans += map.get('X');
                }
            } else if (chars[i] == 'C') {
                if (i != chars.length - 1 && chars[i + 1] == 'D') {
                    ans += 400;
                    i++;
                } else if (i != chars.length - 1 && chars[i + 1] == 'M') {
                    ans += 900;
                    i++;
                } else {
                    ans += map.get('C');
                }
            } else {
                ans += map.get(chars[i]);
            }
        }
        return ans;
    }
}
