package medium;

import java.util.Arrays;

/**
 * 1029. Two City Scheduling
 */

public class Two_City_Scheduling {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        int[] a2bCost = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += costs[i][0];
            a2bCost[i] = costs[i][1] - costs[i][0];
        }
        Arrays.sort(a2bCost);
        for (int i = 0; i < n / 2; i++) {
            sum += a2bCost[i];
        }
        return sum;
    }
}
