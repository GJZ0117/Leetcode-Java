package medium;

import java.util.Arrays;

/**
 * 881. Boats to Save People
 */

public class Boats_to_Save_People {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int i = 0;
        int j = people.length - 1;
        while (i <= j) {
            if (i == j) {
                count++;
                break;
            } else if (people[i] + people[j] <= limit) {
                count++;
                i++;
                j--;
            } else {
                count++;
                j--;
            }
        }
        return count;
    }
}
