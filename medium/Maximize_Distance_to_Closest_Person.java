package medium;

/**
 * 849. Maximize Distance to Closest Person
 */

public class Maximize_Distance_to_Closest_Person {
    public int maxDistToClosest(int[] seats) {
        int start0 = 0;
        int end0 = 0;
        int middle0 = 0;
        int i = 0;
        int j = seats.length - 1;
        while (i < seats.length && seats[i] == 0) {
            start0++;
            i++;
        }
        while (j >= 0 && seats[j] == 0) {
            end0++;
            j--;
        }
        boolean flag = false;
        for (int index = i; index <= j; index++) {
            if (seats[index] == 0 && !flag) {
                flag = true;
            } else if (seats[index] == 1) {
                middle0 = Math.max(middle0, index - i);
                i = index;
                flag = false;
            }
        }
        return Math.max(middle0 / 2, Math.max(start0, end0));
    }
}
