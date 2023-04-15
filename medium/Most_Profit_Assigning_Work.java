package medium;

import java.util.Arrays;

/**
 * 826. Most Profit Assigning Work
 */

public class Most_Profit_Assigning_Work {
    // https://leetcode.cn/problems/most-profit-assigning-work/solution/java-shuang-zhi-zhen-suan-fa-xiang-xi-zh-gugc/

    class Job {
        public int difficulty;
        public int profit;

        public Job(int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;
        }
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int m = worker.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(difficulty[i], profit[i]);
        }
        Arrays.sort(jobs, (a, b) -> a.difficulty - b.difficulty);
        Arrays.sort(worker);

        int top = 0;
        int ans = 0;
        for (int i = 0, j = 0; i < n; i++) {
            while (j < m && worker[j] < jobs[i].difficulty) {
                j++;
            }
            if (j == m) {
                break;
            }
            ans -= (m - j) * top;
            top = Math.max(top, jobs[i].profit);
            ans += (m - j) * top;
        }
        return ans;
    }
}
