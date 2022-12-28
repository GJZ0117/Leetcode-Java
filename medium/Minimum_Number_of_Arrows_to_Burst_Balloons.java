package medium;

/**
 * 452. Minimum Number of Arrows to Burst Balloons
 */

public class Minimum_Number_of_Arrows_to_Burst_Balloons {
    //https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/solution/tu-jie-tan-tao-wei-shi-yao-yao-an-qu-jian-de-you-d/
    public int findMinArrowShots(int[][] points) {
        sortByRightSide(points, 0, points.length - 1);
        int count = 0;
        int i = 0;
        while (i < points.length) {
            int right = points[i][1];
            i++;
            while (i < points.length && points[i][0] <= right) {
                i++;
            }
            count++;
        }
        return count;
    }

    public void sortByRightSide(int[][] points, int low, int high) {
        int[] temp;
        int i = low;
        int j = high;
        if (low < high) {
            temp = points[low];
            while (i < j) {
                while (j > i && points[j][1] >= temp[1]) {
                    j -= 1;
                }
                if (i < j) {
                    points[i] = points[j];
                    i++;
                }
                while (i < j && points[i][1] < temp[1]) {
                    i += 1;
                }
                if (i < j) {
                    points[j] = points[i];
                    j -= 1;
                }
            }

            points[i] = temp;
            sortByRightSide(points, low, i - 1);
            sortByRightSide(points, i + 1, high);
        }
    }
}
