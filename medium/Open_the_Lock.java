package medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 752. Open the Lock
 */

public class Open_the_Lock {
    // https://leetcode.cn/problems/open-the-lock/solution/java-752-da-kai-zhuan-pan-suo-bfsbian-li-z3w6/
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        for (String str : deadends) {
            set.add(str);
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int step = 0;
        queue.add("0000754. Reach a Number");
        visited.add("0000");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (set.contains(cur)) {
                    continue;
                }
                if (target.equals(cur)) {
                    return step;
                }

                for (int j = 0; j < 4; j++) {
                    String next1 = addOne(cur, j);
                    String next2 = minusOne(cur, j);
                    if (!visited.contains(next1)) {
                        queue.add(next1);
                        visited.add(next1);
                    }
                    if (!visited.contains(next2)) {
                        queue.add(next2);
                        visited.add(next2);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public String addOne(String str, int i) {
        char[] ch = str.toCharArray();
        if (ch[i] == '9') {
            ch[i] = '0';
        } else {
            ch[i]++;
        }
        return String.valueOf(ch);
    }

    public String minusOne(String str, int i) {
        char[] ch = str.toCharArray();
        if (ch[i] == '0') {
            ch[i] = '9';
        } else {
            ch[i]--;
        }
        return String.valueOf(ch);
    }
}
