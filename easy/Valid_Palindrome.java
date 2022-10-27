package easy;

/**
 * 125. Valid Palindrome
 */

public class Valid_Palindrome {

    public static void main(String[] args) {
        String str = " ";
        System.out.println(isPalindrome(str));
    }

    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int temp = isAlphanumeric(c);
            if (temp == 1) {
                sb.append(c);
            } else if (temp == 0) {
                sb.append((char) (c + 32));
            }
        }
        String str = sb.toString();
        if (str.length() <= 1) {
            return true;
        }

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

    public static int isAlphanumeric(char c) {
        if ((c >= 97 && c <= 122) || (c - '0' >= 0 && c - '0' <= 9)) {
            return 1;
        } else if (c >= 65 && c <= 90) {
            return 0;
        } else {
            return -1;
        }
    }

}
