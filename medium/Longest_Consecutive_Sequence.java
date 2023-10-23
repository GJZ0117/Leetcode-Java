package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 128. Longest Consecutive Sequence
 */

public class Longest_Consecutive_Sequence {
    public static void main(String[] args) {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (int x : set) {
            if (!set.contains(x - 1)) { //if set contains x-1, it means that x is not a start number of a consecutive number list, then just jump over it
                int y = x + 1;
                while (set.contains(y)) { //find the end number of the consecutive number list which is started from x
                    y++;
                }
                longest = Math.max(longest, y - x);
            }
        }
        return longest;
    }


    // 二刷
    public int longestConsecutive_2(int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        Arrays.stream(nums).forEach(e -> treeSet.add(e));
        int prev = Integer.MIN_VALUE;
        int maxLength = 0;
        int curLength = 0;
        for (int num : treeSet) {
            if (prev == Integer.MIN_VALUE) {
                curLength = 1;
                prev = num;
            } else {
                if (num == prev + 1) {
                    curLength++;
                } else {
                    curLength = 1;
                }
                prev = num;
            }
            maxLength = Math.max(maxLength, curLength);
        }
        return maxLength;
    }
}
