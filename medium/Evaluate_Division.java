package medium;

import java.util.*;

/**
 * 399. Evaluate Division
 */

public class Evaluate_Division {

    class Node {
        String id;
        double num;

        public Node(String id, double num) {
            this.id = id;
            this.num = num;
        }
    }

    Map<String, List<Node>> map = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        double[] res = new double[queries.size()];

        for (int i = 0; i < n; i++) {
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);

            if (!map.containsKey(dividend)) {
                map.put(dividend, new ArrayList<>());
            }
            if (!map.containsKey(divisor)) {
                map.put(divisor, new ArrayList<>());
            }
            map.get(dividend).add(new Node(divisor, values[i]));
            map.get(divisor).add(new Node(dividend, 1 / values[i]));
        }

        int index = 0;
        for (List<String> q : queries) {
            res[index] = dfs(q.get(0), q.get(1), 1.0, new HashSet<>());
            index++;
        }
        return res;
    }

    public double dfs(String cur, String destination, double times, Set<String> set) {
        if (!map.containsKey(cur) || set.contains(cur)) {
            return -1.0;
        }

        if (cur.equals(destination)) {
            return times;
        }

        set.add(cur);

        for (Node node : map.get(cur)) {
            double temp = dfs(node.id, destination, times * node.num, set);
            if (temp != -1.0) {
                return temp;
            }
        }

        return -1.0;
    }
}
