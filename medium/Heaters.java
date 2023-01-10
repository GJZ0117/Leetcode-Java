package medium;

import java.util.Arrays;

/**
 * 475. Heaters
 */

public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int minRadius = 0;
        for (int i = 0, j = 0; i < houses.length; i++) {
            int cur = Math.abs(heaters[j] - houses[i]);
            // find the shortest distance between current house and the heaters which are on the left side of current house
            while (j < heaters.length && heaters[j] <= houses[i]) {
                cur = houses[i] - heaters[j];
                j++;
            }
            // compare the first heater which is on the right side of current house with the shortest left side distance
            if (j < heaters.length) {
                cur = Math.min(cur, Math.abs(heaters[j] - houses[i]));
            }
            minRadius = Math.max(minRadius, cur);
            // return the first heater which is on the left side of current house, because next house will begin from this heater
            if (j > 0) {
                j--;
            }
        }
        return minRadius;
    }
}
