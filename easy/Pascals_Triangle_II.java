package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. Pascal's Triangle II
 */

public class Pascals_Triangle_II {
    public List<Integer> getRow(int rowIndex) {
        rowIndex += 1;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        ans.add(list);
        if (rowIndex == 1) {
            return ans.get(ans.size()-1);
        }
        list = new ArrayList<>();
        list.add(1);
        list.add(1);
        ans.add(list);
        if (rowIndex == 2) {
            return ans.get(ans.size()-1);
        }

        for (int row = 2; row < rowIndex; row++) {
            list = new ArrayList<>();
            list.add(1);
            list.add(1);
            int insertNum = ans.get(row - 1).size() - 1;
            for (int i = 1; i <= insertNum; i++) {
                list.add(i, (ans.get(row - 1).get(i - 1) + ans.get(row - 1).get(i)));
            }
            ans.add(list);
        }
        return ans.get(ans.size()-1);
    }
}
