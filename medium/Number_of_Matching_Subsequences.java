package medium;

import java.util.*;

/**
 * 792. Number of Matching Subsequences
 */

public class Number_of_Matching_Subsequences {

    public static void main(String[] args) {
        String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        System.out.println(numMatchingSubseq(s, words));
    }

    public static int numMatchingSubseq(String s, String[] words) {
        Deque<String>[] deques = new Deque[26];
        for (int i = 0; i < deques.length; i++) {
            deques[i] = new ArrayDeque<>();
        }
        for (String word : words) {
            deques[word.charAt(0) - 'a'].offer(word);
        }
        int ans = 0;
        for (char c : s.toCharArray()) {
            Deque<String> deque = deques[c - 'a'];
            for (int i = deque.size(); i > 0; i--) {
                String str = deque.pollFirst();
                if (str.length() == 1) {
                    ans++;
                } else {
                    deques[str.charAt(1) - 'a'].offer(str.substring(1));
                }
            }
        }
        return ans;
    }

    //Time Limit Exceeded
    public static int _numMatchingSubseq(String s, String[] words) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.get(c).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(c, list);
            }
        }

        int ans = 0;
        for (String word : words) {
            int prevIndex = -1;
            int i = 0;

            while (i < word.length()) {
                char c = word.charAt(i);
                if (!map.containsKey(c)) {
                    break;
                } else {
                    boolean isFind = false;
                    for (int index : map.get(c)) {
                        if (index > prevIndex) {
                            prevIndex = index;
                            isFind = true;
                            break;
                        }
                    }
                    if (!isFind) {
                        break;
                    }
                }
                i++;
            }

            if (i == word.length()) {
                ans++;
            }
        }

        return ans;
    }
}
