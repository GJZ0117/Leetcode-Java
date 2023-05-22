package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 989. Add to Array-Form of Integer
 */

public class Add_to_Array_Form_of_Integer {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> numList = new ArrayList<>();
        List<Integer> kList = new ArrayList<>();
        for (int n : num) {
            numList.add(n);
        }
        while (k != 0) {
            kList.add(0, k % 10);
            k = k / 10;
        }
        int minLen = Math.min(numList.size(), kList.size());
        if (numList.size() < kList.size()) {
            List<Integer> temp = numList;
            numList = kList;
            kList = temp;
        }

        boolean flag = false;
        int i;
        for (i = 0; i < minLen; i++) {
            int cur = numList.get(numList.size() - 1 - i) + kList.get(kList.size() - 1 - i) + (flag ? 1 : 0);
            if (cur >= 10) {
                cur = cur % 10;
                flag = true;
            } else {
                flag = false;
            }
            numList.set(numList.size() - 1 - i, cur);
        }
        if (flag) {
            if (numList.size() - 1 - i >= 0) {
                while (flag && numList.size() - 1 - i >= 0) {
                    int cur = numList.get(numList.size() - 1 - i) + 1;
                    if (cur >= 10) {
                        flag = true;
                        cur = cur % 10;
                    } else {
                        flag = false;
                    }
                    numList.set(numList.size() - 1 - i, cur);
                    i++;
                }
                if (flag) {
                    numList.add(0, 1);
                }
            } else {
                numList.add(0, 1);
            }
        }
        return numList;
    }
}
