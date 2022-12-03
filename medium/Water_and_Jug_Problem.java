package medium;

/**
 * 365. Water and Jug Problem
 */

public class Water_and_Jug_Problem {

    public static void main(String[] args) {
        int jug1 = 34;
        int jug2 = 5;
        int target = 6;
        System.out.println(canMeasureWater(jug1, jug2, target));
    }

    //https://leetcode.cn/problems/water-and-jug-problem/solution/fei-gcdshu-xue-bfsdfsxiao-xue-sheng-du-n-neo2/
    public static boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity + jug2Capacity < targetCapacity) {
            return false;
        }
        int min = Math.min(jug1Capacity, jug2Capacity);
        int max = Math.max(jug1Capacity, jug2Capacity);

        boolean[] record = new boolean[max];
        int remain = 0;
        while (!record[remain]) {
            record[remain] = true;
            remain = (remain + min) % max;
            if (remain == targetCapacity || remain + max == targetCapacity) {
                return true;
            }
        }
        return false;
    }
}
