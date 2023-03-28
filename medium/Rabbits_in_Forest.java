package medium;

/**
 * 781. Rabbits in Forest
 */

public class Rabbits_in_Forest {
    public int numRabbits(int[] answers) {
        int[] counts = new int[1001];
        for (int n : answers) {
            counts[n]++;
        }
        int ans = counts[0];
        for (int i = 1; i <= 1000; i++) {
            int per = i + 1;
            int cnt = counts[i];
            int k = cnt / per;
            if (k * per < cnt) {
                k++;
            }
            ans += k * per;
        }
        return ans;
    }
}
