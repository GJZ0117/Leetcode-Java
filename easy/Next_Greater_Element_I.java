package easy;

import java.util.*;

/**
 * 496. Next Greater Element I
 */

public class Next_Greater_Element_I {

    // better solution
    // https://leetcode.cn/problems/next-greater-element-i/solution/dong-hua-yan-shi-dan-diao-zhan-496xia-yi-ql65/
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }

        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }

    public int[] _nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Arrays.fill(ans, -1);
        for (int i = 0; i < nums1.length; i++) {
            boolean isFind = false;
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]) {
                    isFind = true;
                    continue;
                }
                if (isFind && nums2[j] > nums1[i]) {
                    ans[i] = nums2[j];
                    break;
                }
            }
        }
        return ans;
    }


    // 二刷
    // https://leetcode.cn/problems/next-greater-element-i/solutions/1065517/xia-yi-ge-geng-da-yuan-su-i-by-leetcode-bfcoj/
    public int[] nextGreaterElement_2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            while (!stack.isEmpty() && stack.peekLast() < num) {
                stack.pollLast();
            }
            map.put(num, stack.isEmpty() ? -1 : stack.peekLast());
            stack.addLast(num);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}
