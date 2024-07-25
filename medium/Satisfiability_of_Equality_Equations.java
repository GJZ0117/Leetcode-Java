package medium;

/**
 * 990. Satisfiability of Equality Equations
 */

public class Satisfiability_of_Equality_Equations {
    public boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind(26);

        for (String equation : equations) {
            char[] charArray = equation.toCharArray();
            if (charArray[1] == '=') {
                int index1 = charArray[0] - 'a';
                int index2 = charArray[3] - 'a';
                unionFind.union(index1, index2);
            }
        }

        for (String equation : equations) {
            char[] charArray = equation.toCharArray();
            if (charArray[1] == '!') {
                int index1 = charArray[0] - 'a';
                int index2 = charArray[3] - 'a';

                if (unionFind.isConnected(index1, index2)) {
                    return false;
                }
            }
        }
        return true;
    }

    private class UnionFind {

        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            parent[rootX] = rootY;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }


    // 二刷
    public boolean equationsPossible_2(String[] equations) {
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                int index1 = equation.charAt(0) - 'a';
                int index2 = equation.charAt(3) - 'a';
                union(parent, index1, index2);
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int index1 = equation.charAt(0) - 'a';
                int index2 = equation.charAt(3) - 'a';
                if (find(parent, index1) == find(parent, index2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        while (parent[index] != index) {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }
}
