package medium;

/**
 * 949. Largest Time for Given Digits
 */

public class Largest_Time_for_Given_Digits {
    int maxTime = -1;

    public String largestTimeFromDigits(int[] arr) {
        boolean[] visited = new boolean[arr.length];
        int[] time = new int[arr.length];
        dfs(arr, visited, time, 0);
        return maxTime == -1 ? "" : String.format("%02d:%02d", maxTime / 60, maxTime % 60);
    }

    public void dfs(int[] arr, boolean[] visited, int[] time, int timeIndex) {
        if (timeIndex == arr.length) {
            int hour = time[0] * 10 + time[1];
            int minute = time[2] * 10 + time[3];
            if (hour < 24 && minute < 60) {
                maxTime = Math.max(maxTime, hour * 60 + minute);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                time[timeIndex] = arr[i];
                dfs(arr, visited, time, timeIndex + 1);
                visited[i] = false;
            }
        }
    }
}
