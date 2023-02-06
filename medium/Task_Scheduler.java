package medium;

/**
 * 621. Task Scheduler
 */

public class Task_Scheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] flag = new int[26];
        int maxTask = 0;
        int countMaxTask = 0;
        for (char c : tasks) {
            ++flag[c - 'A'];
            maxTask = Math.max(maxTask, flag[c - 'A']);
        }
        for (int i = 0; i < 26; i++) {
            if (flag[i] == maxTask) {
                countMaxTask++;
            }
        }
        return Math.max(tasks.length, countMaxTask + (n + 1) * (maxTask - 1));
    }
}
