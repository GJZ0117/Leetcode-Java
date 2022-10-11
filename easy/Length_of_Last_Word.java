package easy;

/**
 * 58. Length of Last Word
 */

public class Length_of_Last_Word {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord( "   fly me   to   the moon  "));
    }

    public static int lengthOfLastWord(String s) {
        boolean isLastSpace = s.charAt(s.length() - 1) == ' ';
        int ans = 0;
        for (int i=s.length()-1; i>=0; i--) {
            if (s.charAt(i)!=' '){
                isLastSpace = false;
                ans++;
            }
            if (!isLastSpace && s.charAt(i)==' '){
                break;
            }
        }
        return ans;
    }
}
