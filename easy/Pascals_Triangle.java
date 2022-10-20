package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 */

public class Pascals_Triangle {

    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> lists = generate(numRows);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        ans.add(list);
        if (numRows == 1) {
            return ans;
        }
        list = new ArrayList<>();
        list.add(1);
        list.add(1);
        ans.add(list);
        if (numRows == 2) {
            return ans;
        }

        for (int row = 2; row < numRows; row++) {
            list = new ArrayList<>();
            list.add(1);
            list.add(1);
            int insertNum = ans.get(row - 1).size() - 1;
            for (int i = 1; i <= insertNum; i++) {
                list.add(i, (ans.get(row - 1).get(i - 1) + ans.get(row - 1).get(i)));
            }
            ans.add(list);
        }
        return ans;
    }
}
