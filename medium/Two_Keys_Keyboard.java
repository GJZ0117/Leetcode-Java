package medium;

/**
 * 650. 2 Keys Keyboard
 */

public class Two_Keys_Keyboard {
    //https://leetcode.cn/problems/2-keys-keyboard/solution/gong-shui-san-xie-yi-ti-san-jie-dong-tai-f035/
    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        return dfs(n, 1, 0);
    }

    public int dfs(int n, int cur, int paste) {
        if (cur == n) {
            return 0;
        }
        if (cur > n) {
            return Integer.MAX_VALUE / 2;
        }
        int p1 = cur != paste ? 1 + dfs(n, cur, cur) : Integer.MAX_VALUE / 2;
        int p2 = paste > 0 ? 1 + dfs(n, cur + paste, paste) : Integer.MAX_VALUE / 2;
        return Math.min(p1, p2);
    }
}
