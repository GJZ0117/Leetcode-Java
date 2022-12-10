package easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 500. Keyboard Row
 */

public class Keyboard_Row {

    public static void main(String[] args) {
        String[] words = {"Hello","Alaska","Dad","Peace"};
        System.out.println(Arrays.toString(findWords(words)));
    }

    public static String[] findWords(String[] words) {
        List<String> list = new LinkedList<>();
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        for (int i = 0; i < words.length; i++) {
            String curWord = words[i].toLowerCase();
            int rowIndex = getRowIndex(curWord.charAt(0), rows);
            boolean flag = true;
            for (int j = 1; j < curWord.length(); j++) {
                if (!rows[rowIndex].contains(String.valueOf(curWord.charAt(j)))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(words[i]);
            }
        }
        return list.toArray(new String[list.size()]);
    }

    public static int getRowIndex(char startChar, String[] rows) {
        if (rows[0].contains(String.valueOf(startChar))) {
            return 0;
        } else if (rows[1].contains(String.valueOf(startChar))) {
            return 1;
        } else {
            return 2;
        }
    }
}
