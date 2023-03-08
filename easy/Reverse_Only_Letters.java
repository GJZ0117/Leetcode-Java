package easy;

/**
 * 917. Reverse Only Letters
 */

public class Reverse_Only_Letters {
    public String reverseOnlyLetters(String s) {
        StringBuilder sb = new StringBuilder(s);
        int left = 0;
        int right = sb.length() - 1;
        while (left < right) {
            while (left < right && !Character.isUpperCase(sb.charAt(left)) && !Character.isLowerCase(sb.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isUpperCase(sb.charAt(right)) && !Character.isLowerCase(sb.charAt(right))) {
                right--;
            }
            if (left < right) {
                char c = sb.charAt(left);
                sb.deleteCharAt(left);
                sb.insert(left, sb.charAt(right - 1));
                sb.deleteCharAt(right);
                sb.insert(right, c);
            }
            left++;
            right--;
        }
        return sb.toString();
    }
}
