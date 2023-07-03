package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 967. Numbers With Same Consecutive Differences
 */

public class Numbers_With_Same_Consecutive_Differences {
    public int[] numsSameConsecDiff(int n, int k) {
        int[] num = new int[n];
        Set<Integer> ans = new HashSet<>();
        dfs(ans, num, 0, k);
        int[] res = new int[ans.size()];
        int index = 0;
        for (int p : ans) {
            res[index++] = p;
        }
        return res;
    }

    public void dfs(Set<Integer> ans, int[] num, int index, int k) {
        if (index == num.length) {
            int newNum = 0;
            for (int n : num) {
                newNum = newNum * 10 + n;
            }
            ans.add(newNum);
            return;
        }

        if (index == 0) {
            for (int i = 1; i <= 9; i++) {
                num[index] = i;
                dfs(ans, num, index + 1, k);
            }
        } else {
            if (num[index - 1] - k >= 0 && num[index - 1] - k <= 9) {
                num[index] = num[index - 1] - k;
                dfs(ans, num, index + 1, k);
            }
            if (num[index - 1] + k >= 0 && num[index - 1] + k <= 9) {
                num[index] = num[index - 1] + k;
                dfs(ans, num, index + 1, k);
            }
        }
    }
}
