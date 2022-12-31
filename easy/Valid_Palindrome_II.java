package easy;

/**
 * 680. Valid Palindrome II
 */

public class Valid_Palindrome_II {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return isSubPalindrome(s, left + 1, right) || isSubPalindrome(s, left, right - 1);
            }
        }
        return true;
    }

    public boolean isSubPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
