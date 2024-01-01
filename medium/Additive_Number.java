package medium;

/**
 * 306. Additive Number
 */

public class Additive_Number {
    // https://leetcode.cn/problems/additive-number/solution/tong-ge-lai-shua-ti-la-dfs-jian-zhi-by-t-jxsf/
    public boolean isAdditiveNumber(String num) {
        return dfs(num, 0, 0, 0, 0);
    }

    public boolean dfs(String num, int index, int count, long prevprev, long prev) {
        if (index >= num.length()) {
            return count > 2;
        }

        long current = 0;
        for (int i = index; i < num.length(); i++) {
            char c = num.charAt(i);
            if (num.charAt(index) == '0' && i > index) {
                return false;
            }
            current = current * 10 + c - '0';
            if (count >= 2) {
                long sum = prevprev + prev;
                if (current > sum) {
                    return false;
                }
                if (current < sum) {
                    continue;
                }
            }
            if (dfs(num, i + 1, count + 1, prev, current)) {
                return true;
            }
        }
        return false;
    }


    // 二刷（还不会）
    public boolean isAdditiveNumber_2(String num) {
        return dfs(num, 0, 0, 0, 0);
    }

    private boolean dfsNum(String num, int index, int count, long prevprev, long prev) {
        if (index >= num.length()) {
            return count > 2;
        }
        long current = 0;
        for (int i = index; i < num.length(); i++) {
            char c = num.charAt(i);
            if (num.charAt(index) == '0' && i > index) {
                return false;
            }

            current = current * 10 + c - '0';

            if (count >= 2) {
                long sum = prevprev + prev;
                if (current > sum) {
                    return false;
                }
                if (current < sum) {
                    continue;
                }
            }

            if (dfsNum(num, i + 1, count + 1, prev, current)) {
                return true;
            }
        }
        return false;
    }
}
