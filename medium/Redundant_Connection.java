package medium;

/**
 * 684. Redundant Connection
 */

public class Redundant_Connection {
    // https://leetcode.cn/problems/redundant-connection/solution/tong-su-jiang-jie-bing-cha-ji-bang-zhu-xiao-bai-ku/
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] leader = new int[n + 1];
        int[] res = new int[2];
        for (int i = 0; i < leader.length; i++) {
            leader[i] = i;
        }
        for (int[] edge : edges) {
            int root0 = findRoot(edge[0], leader);
            int root1 = findRoot(edge[1], leader);
            if (root0 != root1) {
                leader[root0] = root1;
            } else {
                return edge;
            }
        }
        return res;
    }

    private int findRoot(int son, int[] leader) {
        int root = son;
        while (root != leader[root]) {
            root = leader[root];
        }
        return root;
    }
}
