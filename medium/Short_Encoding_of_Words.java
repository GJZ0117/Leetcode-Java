package medium;

import java.util.Arrays;

/**
 * 820. Short Encoding of Words
 */

public class Short_Encoding_of_Words {
    class TrieNode {
        char val;
        TrieNode[] children = new TrieNode[26];
    }

    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public int insert(String word) {
            TrieNode cur = root;
            boolean isNew = false;
            for (int i = word.length() - 1; i >= 0; i--) {
                int pos = word.charAt(i) - 'a';
                if (cur.children[pos] == null) {
                    cur.children[pos] = new TrieNode();
                    isNew = true;
                }
                cur = cur.children[pos];
            }
            return isNew ? word.length() + 1 : 0;
        }
    }

    public int minimumLengthEncoding(String[] words) {
        int len = 0;
        Trie trie = new Trie();
        Arrays.sort(words, (a, b) -> b.length() - a.length());
        for (String word : words) {
            len += trie.insert(word);
        }
        return len;
    }
}
