package medium;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 835. Image Overlap
 */

public class Image_Overlap {
    // https://leetcode.cn/problems/image-overlap/solution/javajie-fa-chao-ji-xiang-xi-de-jie-xi-by-coder_hez/
    public int largestOverlap(int[][] A, int[][] B) {
        int N = A.length;
        List<Point> A2 = new ArrayList(), B2 = new ArrayList();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                //将等于1的点添加进去。
                if (A[i][j] == 1) A2.add(new Point(i, j));
                if (B[i][j] == 1) B2.add(new Point(i, j));
            }
        }
        Set<Point> Bset = new HashSet(B2);

        int ans = 0;
        Set<Point> seen = new HashSet();
        for (Point a : A2) {
            //对应A中每个1去与B中每个1去重合
            for (Point b : B2) {
                //这个delta可以理解为A中的点a要走到b这个点需要走多少。例如A中第一个1，走到B中第1个1
                //需要右移动1（b.x-a.x），向下移动1（b.y-a.y）。
                Point delta = new Point(b.x - a.x, b.y - a.y);
                //为了避免相同的位移。比如A中（0，1）处的1想到B中（1，2）处的1也是需要向右移动1，向下移动1
                //那么我们之前计算过一遍就不需要再计算一次了。
                if (!seen.contains(delta)) {
                    seen.add(delta);
                    int cand = 0;
                    //对于A2中的每个点加上位移，去判断是否与B重合
                    for (Point p : A2) {
                        if (Bset.contains(new Point(p.x + delta.x, p.y + delta.y)))
                            cand++;
                    }
                    ans = Math.max(ans, cand);
                }
            }
        }
        return ans;
    }
}
