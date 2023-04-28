package medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 853. Car Fleet
 */

public class Car_Fleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        if (n <= 1) {
            return n;
        }
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }
        Arrays.sort(cars, Comparator.comparing(a -> a[0]));
        double maxTime = cars[n - 1][1];
        int ans = 0;
        for (int i = n - 1; i >= 1; i--) {
            if (maxTime < cars[i - 1][1]) {
                ans++;
                maxTime = cars[i - 1][1];
            }
        }
        ans++;
        return ans;
    }
}
