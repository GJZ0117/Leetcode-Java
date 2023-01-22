package medium;

/**
 * 526. Beautiful Arrangement
 */

public class Beautiful_Arrangement {

    public static void main(String[] args) {
        int n = 15;
        System.out.println(countArrangement(n));
    }

    public static int countArrangement(int n) {
        boolean[] flag = new boolean[n + 1];
        int[] ans = new int[]{0};
        dfs(n, 1, flag, ans);
        return ans[0];
    }

    public static void dfs(int n, int index, boolean[] flag, int[] ans) {
        if (index == n + 1) {
            ans[0]++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!flag[i]) {
                flag[i] = true;
                if (check(i, index)) {
                    dfs(n, index + 1, flag, ans);
                }
                flag[i] = false;
            }
        }
    }

    public static boolean check(int num, int index) {
        return num % index == 0 || index % num == 0;
    }
}
