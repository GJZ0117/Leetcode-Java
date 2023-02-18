package medium;

import java.util.Arrays;

/**
 * 649. Dota2 Senate
 */

public class Dota2_Senate {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        int remain = n;
        boolean[] flag = new boolean[n];
        Arrays.fill(flag, true);
        int rNum = 0;
        int dNum = 0;
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                rNum++;
            } else {
                dNum++;
            }
        }

        int index = -1;
        while (true) {
            index = (index + 1) % n;
            if (!flag[index]) {
                continue;
            }
            if (senate.charAt(index) == 'R') {
                for (int i = (index + 1) % n; i != index; i = (i + 1) % n) {
                    if (senate.charAt(i) == 'D' && flag[i]) {
                        flag[i] = false;
                        dNum--;
                        remain--;
                        break;
                    }
                }
                if (rNum == remain) {
                    return "Radiant";
                }
            } else if (senate.charAt(index) == 'D') {
                for (int i = (index + 1) % n; i != index; i = (i + 1) % n) {
                    if (senate.charAt(i) == 'R' && flag[i]) {
                        flag[i] = false;
                        rNum--;
                        remain--;
                        break;
                    }
                }
                if (dNum == remain) {
                    return "Dire";
                }
            }
        }
    }
}
