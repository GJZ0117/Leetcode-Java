package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 349. Intersection of Two Arrays
 */

public class Intersection_of_Two_Arrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        if (set1.size() > set2.size()) {
            Set<Integer> temp = set1;
            set1 = set2;
            set2 = temp;
        }
        for (int num : set1) {
            if (set2.contains(num)) {
                intersection.add(num);
            }
        }
        int[] ans = new int[intersection.size()];
        int i = 0;
        for (int num : intersection) {
            ans[i++] = num;
        }
        return ans;
    }
}
