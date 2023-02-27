package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 676. Implement Magic Dictionary
 */

public class Implement_Magic_Dictionary {
    class MagicDictionary {
        Map<Integer, List<String>> map = new HashMap<>();

        public MagicDictionary() {

        }

        public void buildDict(String[] dictionary) {
            for (String word : dictionary) {
                int len = word.length();
                if (map.containsKey(len)) {
                    map.get(len).add(word);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(word);
                    map.put(len, list);
                }
            }
        }

        public boolean search(String searchWord) {
            int len = searchWord.length();
            if (!map.containsKey(len)) {
                return false;
            }
            List<String> list = map.get(len);
            for (String word : list) {
                int diff = 0;
                boolean isDiffOne = true;
                for (int i = 0; i < len; i++) {
                    if (searchWord.charAt(i) != word.charAt(i)) {
                        diff++;
                    }
                    if (diff > 1) {
                        isDiffOne = false;
                        break;
                    }
                }
                if (isDiffOne && diff == 1) {
                    return true;
                }
            }
            return false;
        }
    }
}
