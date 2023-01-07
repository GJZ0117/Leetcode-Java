package easy;

/**
 * 744. Find Smallest Letter Greater Than Target
 */

public class Find_Smallest_Letter_Greater_Than_Target {

    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        char target = 'g';
        System.out.println(nextGreatestLetter(letters, target));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int minDist = Integer.MAX_VALUE;
        char minChar = letters[0];
        int curDist;
        for (int i = 0; i < letters.length; i++) {
            char curChar = letters[i];
            if (curChar - target <= 0) {
                curDist = 26 + curChar - target;
            } else {
                curDist = curChar - target;
            }
            System.out.println(curChar + " " + curDist + " " + minDist);

            if (curDist < minDist) {
                minDist = curDist;
                minChar = curChar;
            }
        }
        return minChar;
    }
}
