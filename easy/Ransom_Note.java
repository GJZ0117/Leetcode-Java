package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 383. Ransom Note
 */

public class Ransom_Note {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> mapR = new HashMap<>();
        Map<Character, Integer> mapM = new HashMap<>();
        for (char c : ransomNote.toCharArray()) {
            mapR.put(c, mapR.containsKey(c) ? mapR.get(c) + 1 : 1);
        }
        for (char c : magazine.toCharArray()) {
            mapM.put(c, mapM.containsKey(c) ? mapM.get(c) + 1 : 1);
        }

        for (char c : mapR.keySet()) {
            if (!mapM.containsKey(c) || mapM.get(c) < mapR.get(c)) {
                return false;
            }
        }
        return true;
    }
}
