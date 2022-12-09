package medium;

import java.util.LinkedList;
import java.util.List;

/**
 * 386. Lexicographical Numbers
 */

public class Lexicographical_Numbers {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0, j = 1; i < n; i++) {
            list.add(j);
            if (j * 10 <= n) {
                j *= 10;
            } else {
                while (j % 10 == 9 || j + 1 > n) {
                    j /= 10;
                }
                j++;
            }
        }
        return list;
    }

    public List<Integer> _lexicalOrder(int n) {
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(n, i, list);
        }
        return list;
    }

    public void dfs(int n, int cur, List<Integer> list) {
        if (cur > n) {
            return;
        }
        list.add(cur);
        for (int i = 0; i <= 9; i++) {
            dfs(n, cur * 10 + i, list);
        }
    }
}
