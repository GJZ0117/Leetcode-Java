package medium;

/**
 * 838. Push Dominoes
 */

public class Push_Dominoes {
    // https://leetcode.cn/problems/push-dominoes/solution/pythonjavajavascriptgo-zheng-fan-bian-li-xeyv/
    public String pushDominoes(String dominoes) {
        int INF = Integer.MAX_VALUE;
        int n = dominoes.length();
        int[][] record = new int[n][2];
        for (int i = n - 1, cur = INF; i >= 0; i--) {
            char c = dominoes.charAt(i);
            if (c == 'L') {
                cur = i;
            } else if (c == 'R') {
                cur = INF;
            }
            record[i][0] = cur == INF ? INF : cur - i;
        }
        for (int i = 0, cur = -INF; i < n; i++) {
            char c = dominoes.charAt(i);
            if (c == 'R') {
                cur = i;
            } else if (c == 'L') {
                cur = -INF;
            }
            record[i][1] = cur == -INF ? INF : i - cur;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (record[i][0] == record[i][1]) {
                sb.append(".");
            } else if (record[i][0] > record[i][1]) {
                sb.append("R");
            } else {
                sb.append("L");
            }
        }

        return sb.toString();
    }
}
