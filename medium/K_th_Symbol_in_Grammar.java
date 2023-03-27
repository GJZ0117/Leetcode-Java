package medium;

/**
 * 779. K-th Symbol in Grammar
 */

public class K_th_Symbol_in_Grammar {
    public int kthGrammar(int n, int k) {
        return dfs(n, k);
    }

    private int dfs(int n, int k) {
        if (n == 1) {
            return 0;
        }
        int len = (int) Math.pow(2, n - 2);
        if (k - len <= 0) {
            return dfs(n - 1, k);
        } else {
            return dfs(n - 1, k - len) == 0 ? 1 : 0;
        }
    }
}
