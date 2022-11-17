package easy;

import java.util.LinkedList;
import java.util.List;

/**
 * 401. Binary Watch
 */

public class Binary_Watch {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new LinkedList<>();
        if (turnedOn >= 9) {
            return ans;
        }
        int[] time = {8, 4, 2, 1, 32, 16, 8, 4, 2, 1};
        dfs(turnedOn, ans, time, 0, 0, 0);
        return ans;
    }

    public void dfs(int turnedOn, List<String> ans, int[] time, int start, int hour, int minute) {
        if (turnedOn == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(hour);
            sb.append(":");
            if (minute < 10) {
                sb.append("0");
            }
            sb.append(minute);
            ans.add(sb.toString());
            return;
        }

        for (int i = start; i < time.length; i++) {
            int tempHour = i < 4 ? hour + time[i] : hour;
            int tempMinute = i < 4 ? minute : minute + time[i];
            if ((i < 4 && tempHour > 11) || (i >= 4 && tempMinute > 59)) {
                continue;
            }
            dfs(turnedOn - 1, ans, time, i + 1, tempHour, tempMinute);
        }
    }
}
