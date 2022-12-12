package easy;

/**
 * 520. Detect Capital
 */

public class Detect_Capital {
    public boolean detectCapitalUse(String word) {
        // case 2 is false
        if (Character.isUpperCase(word.charAt(0))) {
            boolean isAllUpper = true;
            boolean isUpperwithLower = true;
            for (int i = 1; i < word.length(); i++) {
                if (Character.isLowerCase(word.charAt(i))) {
                    isAllUpper = false;
                } else {
                    isUpperwithLower = false;
                }

                if (!isAllUpper && !isUpperwithLower) {
                    return false;
                }
            }
            return true;
        } else {
            // case 1 and 3 are false
            for (int i = 1; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    }
}
