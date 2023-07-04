package easy;

/**
 * 997. Find the Town Judge
 */

public class Find_the_Town_Judge {
    public int findJudge(int n, int[][] trust) {
        int[] trustOthers = new int[n];
        int[] beTrusted = new int[n];
        for (int[] arr : trust) {
            int from = arr[0] - 1;
            int to = arr[1] - 1;
            trustOthers[from]++;
            beTrusted[to]++;
        }
        for (int i = 0; i < n; i++) {
            if (trustOthers[i] == 0 && beTrusted[i] == n - 1) {
                return i + 1;
            }
        }
        return -1;
    }
}
