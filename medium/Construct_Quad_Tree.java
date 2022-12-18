package medium;

/**
 * 427. Construct Quad Tree
 */

class QuadNode {
    public boolean val;
    public boolean isLeaf;
    public QuadNode topLeft;
    public QuadNode topRight;
    public QuadNode bottomLeft;
    public QuadNode bottomRight;


    public QuadNode() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public QuadNode(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public QuadNode(boolean val, boolean isLeaf, QuadNode topLeft, QuadNode topRight, QuadNode bottomLeft, QuadNode bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};

public class Construct_Quad_Tree {
    public QuadNode construct(int[][] grid) {
        return dfs(grid, 0, 0, grid.length);
    }

    public QuadNode dfs(int[][] grid, int start_i, int start_j, int len) {
        QuadNode root = new QuadNode();
        if (len == 1 || checkLeaf(grid, start_i, start_j, len)) {
            root.isLeaf = true;
            root.val = grid[start_i][start_j] == 1;
            return root;
        }
        root.topLeft = dfs(grid, start_i, start_j, len / 2);
        root.topRight = dfs(grid, start_i, start_j + len / 2, len / 2);
        root.bottomLeft = dfs(grid, start_i + len / 2, start_j, len / 2);
        root.bottomRight = dfs(grid, start_i + len / 2, start_j + len / 2, len / 2);
        return root;
    }

    public boolean checkLeaf(int[][] grid, int start_i, int start_j, int len) {
        for (int i = start_i; i < start_i + len; i++) {
            for (int j = start_j; j < start_j + len; j++) {
                if (grid[i][j] != grid[start_i][start_j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
