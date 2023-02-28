package medium;

/**
 * 677. Map Sum Pairs
 */

public class Map_Sum_Pairs {
    class MapSum {

        private class Node {
            Node[] children = new Node[26];
            int val = 0;
        }

        private Node root;

        public MapSum() {
            this.root = new Node();
        }

        public void insert(String key, int val) {
            Node node = this.root;
            for (int i = 0; i < key.length(); i++) {
                int index = key.charAt(i) - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Node();
                }
                node = node.children[index];
            }
            node.val = val;
        }

        public int sum(String prefix) {
            Node node = this.root;
            for (int i = 0; i < prefix.length(); i++) {
                int index = prefix.charAt(i) - 'a';
                node = node.children[index];
                if (node == null) {
                    return 0;
                }
            }
            return dfs(node);
        }

        private int dfs(Node node) {
            if (node == null) {
                return 0;
            }
            int ans = 0;
            if (node.val > 0) {
                ans = node.val;
            }
            for (Node child : node.children) {
                ans += dfs(child);
            }
            return ans;
        }
    }
}
