package medium;

import java.util.*;

/**
 * 50. Pow(x, n)
 */

public class Pow_x_n {
    public static void main(String[] args) {
        double x = 2.0;
        int n = Integer.MIN_VALUE + 1;
        System.out.println(myPow(x, n));
    }

    public static double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        } else if (x == 1) {
            return x;
        } else if (x == -1) {
            return n % 2 == 0 ? 1 : -1;
        } else if (n == 0) {
            return 1;
        } else if (n == Integer.MIN_VALUE) {
            return 0;
        }

        boolean isNPositive = n > 0;
        n = Math.abs(n);
        List<Integer> indexList = new ArrayList<>();
        List<Double> resList = new ArrayList<>();

        indexList.add(n);
        resList.add(x);

        int i = n;
        while (i > 1) {
            if (i % 2 == 0) {
                i /= 2;
                indexList.add(i);

            } else {
                i -= 1;
                i /= 2;
                indexList.add(i);
            }
        }
        Collections.reverse(indexList);

        for (i = 1; i < indexList.size(); i++) {
            double temp = resList.get(i - 1);
            if (indexList.get(i) % 2 == 0) {
                resList.add(temp * temp);
            } else {
                resList.add(temp * temp * x);
            }
        }

        double lastNum = resList.get(resList.size() - 1);
        return isNPositive ? lastNum : (1 / lastNum);
    }


    // 二刷 还不会
    // https://leetcode.cn/problems/powx-n/solutions/241471/50-powx-n-kuai-su-mi-qing-xi-tu-jie-by-jyd/
    public double myPow_2(double x, int n) {
        if (x == 0) {
            return 0;
        }
        long b = n;
        double res = 1;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * x;
            }
            x = x * x;
            b = b >> 1;
        }
        return res;
    }
}
