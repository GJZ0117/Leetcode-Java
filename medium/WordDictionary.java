package medium;

/**
 * 211. Design Add and Search Words Data Structure
 */

public class WordDictionary {

    class TrieNode {
        boolean end;
        TrieNode[] children = new TrieNode[26];
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curRoot = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curRoot.children[index] == null) {
                curRoot.children[index] = new TrieNode();
            }
            curRoot = curRoot.children[index];
        }
        curRoot.end = true;
    }

    public boolean search(String word) {
        return dfs(word, root, 0);
    }

    public boolean dfs(String word, TrieNode node, int wordIndex) {
        int n = word.length();
        if (n == wordIndex) {
            return node.end;
        }
        char curChar = word.charAt(wordIndex);
        if (curChar == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null && dfs(word, node.children[i], wordIndex + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            int index = curChar - 'a';
            if (node.children[index] == null) {
                return false;
            }
            return dfs(word, node.children[index], wordIndex + 1);
        }
    }
}


// 二刷
class WordDictionary_2 {

    class TrieNode {
        TrieNode[] val = new TrieNode[26];
        boolean isEnd;
    }

    TrieNode root;

    public WordDictionary_2() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.val[c - 'a'] == null) {
                cur.val[c - 'a'] = new TrieNode();
            }
            cur = cur.val[c - 'a'];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    public boolean search(String word, int index, TrieNode cur) {
        if (index == word.length()) {
            return cur.isEnd;
        }
        if (word.charAt(index) == '.') {
            for (int i = 0; i < 26; i++) {
                if (cur.val[i] != null && search(word, index + 1, cur.val[i])) {
                    return true;
                }
            }
            return false;
        } else {
            if (cur.val[word.charAt(index) - 'a'] == null) {
                return false;
            } else {
                return search(word, index + 1, cur.val[word.charAt(index) - 'a']);
            }
        }
    }
}
