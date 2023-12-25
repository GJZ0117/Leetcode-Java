package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 279. Perfect Squares
 */

public class Perfect_Squares {

    public static void main(String[] args) {
        int n = 12;
        System.out.println(numSquares(n));
    }

    public static int numSquares(int n) {
        List<Integer> candidates = new LinkedList<>();
        int[] leastNum = {Integer.MAX_VALUE};
        for (int i = 1; i <= Math.sqrt(n); i++) {
            candidates.add(i * i);
        }
        Collections.reverse(candidates);
        dfs(n, new LinkedList<>(), candidates, 0, leastNum);
        return leastNum[0];
    }

    public static void dfs(int remain, List<Integer> temp, List<Integer> candidates, int start, int[] leastNum) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            leastNum[0] = Math.min(temp.size(), leastNum[0]);
            System.out.println(temp);
            return;
        }

        for (int i = start; i < candidates.size(); i++) {
            if (temp.size() >= leastNum[0]) {
                break;
            }
            int curCandidate = candidates.get(i);
            temp.add(curCandidate);
            dfs(remain - curCandidate, temp, candidates, i, leastNum);
            temp.remove(temp.size() - 1);
        }
    }


    // 二刷

    int count = Integer.MAX_VALUE;

    public int numSquares_2(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            list.add(i * i);
        }
        Collections.reverse(list);
        recure(list, 0, new ArrayList<>(), n);
        return count;
    }

    private void recure(List<Integer> list, int start, List<Integer> temp, int remain) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            count = Math.min(count, temp.size());
            return;
        }
        for (int i = start; i < list.size(); i++) {
            if (temp.size() > count) {
                break;
            }
            int num = list.get(i);
            temp.add(num);
            recure(list, i, temp, remain - num);
            temp.remove(temp.size() - 1);
        }
    }
}
