package medium;

import java.util.*;

/**
 * 229. Majority Element II
 */

public class Majority_Element_II {

    public List<Integer> betterSolution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new LinkedList<>();
        }
        List<Integer> list = new LinkedList<>();
        int num1 = nums[0];
        int count1 = 0;
        int num2 = nums[0];
        int count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num1) {
                count1++;
            } else if (nums[i] == num2) {
                count2++;
            } else if (count1 == 0) {
                num1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                num2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num1) {
                count1++;
            } else if (nums[i] == num2) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) {
            list.add(num1);
        }
        if (count2 > nums.length / 3) {
            list.add(num2);
        }
        return list;
    }

    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new LinkedList<>();
        for (int num : nums) {
            map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1);
        }
        int showTimes = nums.length / 3;
        for (int num : map.keySet()) {
            if (map.get(num) > showTimes) {
                list.add(num);
            }
        }
        return list;
    }


    // 二刷
    public List<Integer> majorityElement_2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        double size = ((double) nums.length) / 3.0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if ((double) entry.getValue() > size) {
                list.add(entry.getKey());
            }
        }
        return list;
    }
}
