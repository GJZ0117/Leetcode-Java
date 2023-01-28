package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 830. Positions of Large Groups
 */

public class Positions_of_Large_Groups {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = s.length();
        int start = 0;
        int end = 1;
        while (end < n) {
            if (s.charAt(end) != s.charAt(start)) {
                if (end - start >= 3) {
                    List<Integer> list = new ArrayList<>();
                    list.add(start);
                    list.add(end - 1);
                    ans.add(list);
                }
                start = end;
                end = start + 1;
            } else {
                end++;
            }
        }
        if (end - start >= 3) {
            List<Integer> list = new ArrayList<>();
            list.add(start);
            list.add(end - 1);
            ans.add(list);
        }
        return ans;
    }
}
