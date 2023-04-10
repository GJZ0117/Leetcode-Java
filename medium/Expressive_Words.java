package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 809. Expressive Words
 */

public class Expressive_Words {
    public int expressiveWords(String s, String[] words) {
        List<Character> charList = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        char curChar = s.charAt(0);
        int num = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == curChar) {
                num++;
            } else {
                charList.add(curChar);
                numList.add(num);
                curChar = s.charAt(i);
                num = 1;
            }
        }
        charList.add(curChar);
        numList.add(num);

        int ans = 0;
        for (String word : words) {
            int sListIndex = 0;
            boolean flag = true;
            curChar = word.charAt(0);
            num = 1;
            for (int i = 1; i < word.length() && sListIndex < charList.size(); i++) {
                if (word.charAt(i) == curChar) {
                    num++;
                } else {
                    if (curChar != charList.get(sListIndex) || num > numList.get(sListIndex) || (num < numList.get(sListIndex) && numList.get(sListIndex) < 3)) {
                        flag = false;
                        break;
                    }
                    sListIndex++;
                    curChar = word.charAt(i);
                    num = 1;
                }
            }
            if (flag && sListIndex < charList.size() && (curChar != charList.get(sListIndex) || num > numList.get(sListIndex) || (num < numList.get(sListIndex) && numList.get(sListIndex) < 3))) {
                flag = false;
            } else {
                sListIndex++;
            }

            if (flag && sListIndex == charList.size()) {
                ans++;
            }

        }
        return ans;
    }
}
