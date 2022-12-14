package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 406. Queue Reconstruction by Height
 */

public class Queue_Reconstruction_by_Height {

    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        System.out.println(Arrays.deepToString(reconstructQueue(people)));
    }

    //https://leetcode.cn/problems/queue-reconstruction-by-height/solution/xian-pai-xu-zai-cha-dui-dong-hua-yan-shi-suan-fa-g/
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                if (p1[0] != p2[0]) {
                    return p2[0] - p1[0];
                } else {
                    return p1[1] - p2[1];
                }
            }
        });
        List<int[]> list = new ArrayList<>();
        for (int[] p : people) {
            if (list.size() <= p[1]) {
                list.add(p);
            } else if (list.size() > p[1]) {
                list.add(p[1], p);
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}
