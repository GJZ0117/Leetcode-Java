package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 898. Bitwise ORs of Subarrays
 */

public class Bitwise_ORs_of_Subarrays {

    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> ans = new HashSet<>();
        Set<Integer> cur = new HashSet<>();
        cur.add(0);
        for (int n1 : arr) {
            Set<Integer> cur2 = new HashSet<>();
            for (int n2 : cur) {
                cur2.add(n1 | n2);
            }
            cur2.add(n1);
            cur = cur2;
            ans.addAll(cur);
        }
        return ans.size();
    }

    // Time Limit Exceeded
    public int _subarrayBitwiseORs(int[] arr) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int n : arr) {
            set.add(n);
            list.add(n);
        }
        int originalNum = list.size();
        for (int i = 0; i < originalNum; i++) {
            int cur = list.get(i);
            for (int j = i + 1; j < originalNum; j++) {
                cur = cur | list.get(j);
                if (!set.contains(cur)) {
                    set.add(cur);
                    list.add(cur);
                }
            }
        }
        return set.size();
    }
}
