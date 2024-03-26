package medium;

import java.util.Arrays;

/**
 * 1011. Capacity To Ship Packages Within D Days
 */

public class Capacity_To_Ship_Packages_Within_D_Days {
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = 0;
        int totalWeight = 0;
        for (int weight : weights) {
            maxWeight = Math.max(maxWeight, weight);
            totalWeight += weight;
        }
        int left = maxWeight;
        int right = totalWeight;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (verify(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean verify(int[] weights, int days, int maxWeight) {
        int dayCount = 0;
        int curWeight = 0;
        for (int weight : weights) {
            curWeight += weight;
            if (curWeight > maxWeight) {
                dayCount++;
                curWeight = weight;
            }
            if (dayCount >= days) {
                return false;
            }
        }
        return true;
    }


    // 二刷
    // https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days/solutions/744307/java-er-fen-cha-zhao-zhu-shi-ban-qing-xi-7f7b/
    public int shipWithinDays_2(int[] weights, int days) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (verification(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean verification(int[] weights, int D, int H) {
        int count = 1;
        int singleWeight = 0;
        for (int i = 0; i < weights.length; i++) {
            singleWeight += weights[i];
            if (singleWeight > H) {
                count++;
                singleWeight = weights[i];
            }
            if (count > D) {
                return false;
            }
        }
        return true;
    }
}
