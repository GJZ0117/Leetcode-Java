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

    // https://leetcode.cn/problems/water-and-jug-problem/solution/fei-gcdshu-xue-bfsdfsxiao-xue-sheng-du-n-neo2/
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


    // 二刷（还不会）
    // 整个过程为：装满小桶，往大桶倒，直到倒满大桶，此时小桶剩下remain，把大桶清空，小桶把remain倒往大桶，如此重复
    public boolean canMeasureWater_2(int jug1, int jug2, int target) {
        if (target > jug1 + jug2) {
            return false;
        }
        int min = Math.min(jug1, jug2);
        int max = Math.max(jug1, jug2);
        // 记录是否出现一个周期，是则说明永远达不到目标
        boolean[] record = new boolean[max];
        int remain = 0;
        while (!record[remain]) {
            record[remain] = true;
            remain = (remain + min) % max;
            // 情况一：remain为需要的结果target(true)或者出现周期(false),结果在某一个桶中
            // 情况二：remain+大桶容量=target
            if (remain == target || remain + max == target) {
                return true;
            }
        }
        return false;
    }
}
