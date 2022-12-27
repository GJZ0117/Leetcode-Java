package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 682. Baseball Game
 */

public class Baseball_Game {
    public int calPoints(String[] operations) {
        List<Integer> list = new ArrayList<>();
        for (String str : operations) {
            if (str.equals("C")) {
                list.remove(list.size() - 1);
            } else if (str.equals("D")) {
                int pre = list.get(list.size() - 1);
                list.add(pre * 2);
            } else if (str.equals("+")) {
                int pre1 = list.get(list.size() - 1);
                int pre2 = list.get(list.size() - 2);
                list.add(pre1 + pre2);
            } else {
                list.add(Integer.parseInt(str));
            }
        }
        int ans = 0;
        for (int num : list) {
            ans += num;
        }
        return ans;
    }
}
