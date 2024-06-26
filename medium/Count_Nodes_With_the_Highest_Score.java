package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 2049. Count Nodes With the Highest Score
 */

public class Count_Nodes_With_the_Highest_Score {

    long maxScore = 0;
    int count = 0;
    int n;
    List<Integer>[] children;

    public int countHighestScoreNodes(int[] parents) {
        n = parents.length;
        children = new List[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int p = parents[i];
            if (p != -1) {
                children[p].add(i);
            }
        }
        dfs(0);
        return count;
    }

    public int dfs(int node) {
        long score = 1;
        int size = n - 1;
        for (int c : children[node]) {
            int t = dfs(c);
            score *= t;
            size -= t;
        }

        if (node != 0) {
            score *= size;
        }

        if (score == maxScore) {
            count++;
        } else if (score > maxScore) {
            maxScore = score;
            count = 1;
        }

        return n - size;
    }
}
