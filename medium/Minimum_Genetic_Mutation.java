package medium;

/**
 * 433. Minimum Genetic Mutation
 */

public class Minimum_Genetic_Mutation {
    public int minMutation(String startGene, String endGene, String[] bank) {
        int[] minTimes = {Integer.MAX_VALUE};
        boolean[] visited = new boolean[bank.length];
        dfs(startGene, endGene, bank, visited, minTimes, 0);
        return minTimes[0] == Integer.MAX_VALUE ? -1 : minTimes[0];
    }

    public void dfs(String startGene, String endGene, String[] bank, boolean[] visited, int[] minTimes, int curTimes) {
        for (int i = 0; i < bank.length; i++) {
            if (!visited[i] && checkDiff(startGene, bank[i])) {
                if (endGene.equals(bank[i])) {
                    curTimes++;
                    minTimes[0] = Math.min(minTimes[0], curTimes);
                    return;
                } else {
                    visited[i] = true;
                    dfs(bank[i], endGene, bank, visited, minTimes, curTimes+1);
                    visited[i] = false;
                }
            }
        }
    }

    public boolean checkDiff(String str1, String str2) {
        int diff = 0;
        for (int i = 0; i < 8; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }
}
