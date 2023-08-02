package medium;

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
}
