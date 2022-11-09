package medium;

/**
 * 134. Gas Station
 */

public class Gas_Station {

    public int betterSolution(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if (totalCost > totalGas) { // if total cost is more than total gas, it can never finish a circle
            return -1;
        }

        int start = 0; // record the start index
        int curGas = 0; // record when the car reach each station, how much gas it has remained
        for (int i = 0; i < gas.length; i++) {
            curGas += gas[i] - cost[i];
            if (curGas < 0) { // if the remaining gas is less than 0 at index i, it proves that when the car start from start index to i-1 index can not reach i
                start = i + 1; // try start from i+1
                curGas = 0; // reset remaining gas
            }
        }
        return start;
    }

    //https://leetcode.cn/problems/gas-station/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--30/
    //Time Limit Exceeded
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;

        int[] farIndex = new int[len]; // record when i is the start index, where can it reach furthest
        for (int i = 0; i < len; i++) {
            farIndex[i] = -1;
        }
        int[] farIndexRemain = new int[len]; // record when reach the furthest index, the remain gas

        for (int i = 0; i < len; i++) {
            int j = i;
            int remain = gas[i];
            while (remain - cost[j] >= 0) {
                remain = remain - cost[j];
                j = (j + 1) % len;
                if (farIndex[j] != -1) { // check if have tarversed this index before
                    remain = remain + farIndexRemain[j];
                    j = farIndex[j];
                } else {
                    remain = remain + gas[j];
                }
                if (i == j) {
                    return i;
                }
            }
            farIndex[i] = j;
            farIndexRemain[i] = remain;
        }
        return -1;
    }
}