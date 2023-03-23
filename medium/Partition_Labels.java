package medium;

import java.util.*;

/**
 * 763. Partition Labels
 */

public class Partition_Labels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            arr[chars[i] - 'a'] = i;
        }
        int start = 0;
        int scannedCharMaxPosition = 0;
        for (int i = 0; i < chars.length; i++) {
            int curCharMaxPosition = arr[chars[i] - 'a'];
            scannedCharMaxPosition = Math.max(scannedCharMaxPosition, curCharMaxPosition);
            if (i == scannedCharMaxPosition) {
                ans.add(i - start + 1);
                start = i + 1;
            }
        }
        return ans;
    }


    public List<Integer> _partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Set<Character> set = new HashSet<>();
        int startIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            set.add(chars[i]);
            map.put(chars[i], map.get(chars[i]) - 1);
            boolean flag = true;
            for (char c : set) {
                if (map.get(c) != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans.add(i - startIndex + 1);
                startIndex = i + 1;
            }
        }
        return ans;
    }
}
