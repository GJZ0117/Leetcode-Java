package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 842. Split Array into Fibonacci Sequence
 */

public class Split_Array_into_Fibonacci_Sequence {

    //https://leetcode.cn/problems/split-array-into-fibonacci-sequence/solution/javahui-su-suan-fa-tu-wen-xiang-jie-ji-b-vg5z/
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> list = new ArrayList<>();
        dfs(num.toCharArray(), list, 0);
        return list;
    }

    public boolean dfs(char[] digit, List<Integer> list, int index) {
        if (index == digit.length && list.size() >= 3) {
            return true;
        }

        for (int i = index; i < digit.length; i++) {
            if (digit[index] == '0' && i > index) {
                break;
            }
            long num = subDigit(digit, index, i + 1);
            if (num > Integer.MAX_VALUE) {
                break;
            }
            int size = list.size();
            if (size >= 2 && num > list.get(size - 1) + list.get(size - 2)) {
                break;
            }
            if (size <= 1 || num == list.get(size - 1) + list.get(size - 2)) {
                list.add((int) num);
                if (dfs(digit, list, i + 1))
                    return true;
                list.remove(list.size() - 1);
            }
        }
        return false;
    }

    private long subDigit(char[] digit, int start, int end) {
        long res = 0;
        for (int i = start; i < end; i++) {
            res = res * 10 + digit[i] - '0';
        }
        return res;
    }
}
