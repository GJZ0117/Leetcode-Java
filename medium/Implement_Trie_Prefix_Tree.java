package medium;

import java.util.LinkedList;
import java.util.List;

/**
 * 208. Implement Trie (Prefix Tree)
 */

class Trie {

    class TrieNode {
        char val;
        List<TrieNode> children = new LinkedList<>();
        boolean isEnd;
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curRoot = root;
        boolean isFound;
        for (int i = 0; i < word.length(); i++) {
            char curChar = word.charAt(i);
            isFound = false;
            for (TrieNode child : curRoot.children) {
                if (child.val == curChar) {
                    isFound = true;
                    curRoot = child;
                    break;
                }
            }
            if (!isFound) {
                TrieNode node = new TrieNode();
                node.val = curChar;
                curRoot.children.add(node);
                curRoot = node;
            }
        }
        curRoot.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode curRoot = root;
        boolean isFound;
        for (int i = 0; i < word.length(); i++) {
            char curChar = word.charAt(i);
            isFound = false;
            for (TrieNode child : curRoot.children) {
                if (child.val == curChar) {
                    curRoot = child;
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                return false;
            }
        }
        return curRoot.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curRoot = root;
        for (int i = 0; i < prefix.length(); i++) {
            char curChar = prefix.charAt(i);
            boolean isFound = false;
            for (TrieNode child : curRoot.children) {
                if (child.val == curChar) {
                    curRoot = child;
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                return false;
            }
        }
        return true;
    }
}