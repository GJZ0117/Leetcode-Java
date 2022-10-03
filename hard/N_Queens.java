package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N-Queens
 */

public class N_Queens {

    public static void main(String[] args) {
        List<List<String>> ans = solveNQueens(1);
        for (List<String> list : ans) {
            System.out.println(list);
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[] array = new int[n];
        check(ans, array, n, 0);
        return ans;
    }

    public static void check(List<List<String>> ans, int[] array, int max, int n) {
        if (n == max) {
            List<String> stringList = new ArrayList<>();
            for (int i = 0; i < max; ++i) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < max; j++) {
                    if (j == array[i]) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                stringList.add(sb.toString());
            }
            ans.add(stringList);
            return;
        }
        for (int i = 0; i < max; i++) {
            array[n] = i;
            if (judge(array, n)) {
                check(ans, array, max, n + 1);
            }
        }

    }

    public static boolean judge(int[] array, int n) {
        for (int i = 0; i < n; ++i) {
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

}
