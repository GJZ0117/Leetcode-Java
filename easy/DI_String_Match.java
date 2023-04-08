package easy;

/**
 * 942. DI String Match
 */

public class DI_String_Match {
    public int[] diStringMatch(String s) {
        char[] chars = s.toCharArray();
        int max = chars.length;
        int min = 0;
        int[] arr = new int[max + 1];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'I') {
                arr[i] = min;
                min++;
            } else {
                arr[i] = max;
                max--;
            }
        }
        arr[s.length()] = max;
        return arr;
    }
}
