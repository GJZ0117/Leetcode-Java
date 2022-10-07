package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 409. Longest Palindrome
 */

public class Longest_Palindrome {

    public static void main(String[] args) {
        String s = "Aa";
        System.out.println(longestPalindrome(s));
    }

    public static int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        boolean hasOdd = false;
        Character character;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            character = s.charAt(i);
            if (map.containsKey(character)) {
                map.put(character, map.get(character) + 1);
            } else {
                map.put(character, 1);
            }
        }
        for (Integer integer : map.values()) {
            if (integer % 2 == 0) {
                ans += integer;
            } else {
                ans += integer-1;
                hasOdd = true;
            }
        }
        return hasOdd ? ans + 1 : ans;
    }
}
