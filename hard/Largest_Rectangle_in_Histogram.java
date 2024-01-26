package hard;

import java.util.Stack;

/**
 * 84. Largest Rectangle in Histogram
 */

public class Largest_Rectangle_in_Histogram {

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(betterSolution(heights));
    }


    /**
     * https://www.sohu.com/a/454782608_120437685
     * 先将题目给定的数组左右各添加一个元素0，为了方便确定原有数组中第一个元素和最后一个元素能不能继续扩张
     * 然后开始从左到右依次遍历数组中的元素
     * 如果栈为空或者当前考察的新元素值比栈顶元素值大，表明以栈顶元素值为高的矩形面积暂不能确定，所以就将当前考察的新元素入栈。在这个条件下，栈中的元素值从栈底到栈顶是依次递增的
     * 如果栈不为空且当前考察的新元素值比栈顶元素值小，表明以栈顶元素值为高的矩形的面积是可以确定的了。该矩形的高就是栈顶元素值，其右侧边界就是当前考察的新元素，左侧边界是栈顶元素的前一个元素，因为，在上一步中我们知道栈中元素值从栈底到栈顶是依次递增的。 因此，矩形的宽是当前考察的元素索引与栈顶元素前一个元素的索引的差值减一。=
     */
    public static int betterSolution(int[] heights) {
        int res = 0; // 初始化结果为0
        Stack<Integer> stack = new Stack<>(); // 递增栈
        // 将给定的原数组左右各添加一个0
        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int i = 1; i < heights.length + 1; i++) {
            newHeights[i] = heights[i - 1];
        }

        for (int i = 0; i < newHeights.length; i++) {
            // 栈不空且当前元素值小于栈顶元素值，则表示以栈顶元素为高的矩形面积可以确定
            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                int cur = stack.pop(); // 弹出栈顶元素
                int curHeight = newHeights[cur]; // 获取栈顶元素对应高
                int leftIndex = stack.peek(); // 栈顶元素弹出后，新的栈顶元素是其左边界
                int rightIndex = i; // 右边界是当前考察的索引
                int curWidth = rightIndex - leftIndex - 1; // 计算矩形宽度
                res = Math.max(res, curWidth * curHeight); // 计算面积
            }
            stack.push(i); // 当前考察元素入栈
        }
        return res;
    }

    // 结果正确，超时
    public static int largestRectangleArea(int[] heights) {
        return find(heights, 0, heights.length - 1);
    }

    public static int find(int[] heights, int start, int end) {
        if (start <= end) {
            int smallIndex = findSmallestIndex(heights, start, end);
            int curRectangle = (end - start + 1) * heights[smallIndex];
            int leftRectangle = find(heights, start, smallIndex - 1);
            int rightRectangle = find(heights, smallIndex + 1, end);
            return Math.max(curRectangle, Math.max(leftRectangle, rightRectangle));

        } else {
            return 0;
        }

    }

    public static int findSmallestIndex(int[] heights, int start, int end) {
        int smallIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (heights[i] < heights[smallIndex]) {
                smallIndex = i;
            }
        }
        return smallIndex;
    }
}
