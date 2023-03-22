package medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 756. Pyramid Transition Matrix
 */

public class Pyramid_Transition_Matrix {
    private String allowedString = "ABCDEFG";

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        if (allowed.size() == 0) {
            return false;
        }
        Map<String, Integer> allowedNums = convert(allowed);
        return dealNextFloor(allowedNums, "", bottom, 0);
    }

    private boolean dealNextFloor(Map<String, Integer> allowedNums, String bottom, String origin, int k) {
        if (k == origin.length() - 1) {
            return origin.length() == 1 || dealNextFloor(allowedNums, "", bottom, 0);
        }
        String key = origin.substring(k, k + 2);
        if (!allowedNums.containsKey(key)) {
            return false;
        }
        int allowNum = allowedNums.get(key);
        if (allowNum > 0) {
            for (int j = 0; j < 7; j++) {
                if ((allowNum >> j & 1) == 1) {
                    bottom += allowedString.charAt(j);
                    boolean flag = dealNextFloor(allowedNums, bottom, origin, k + 1);
                    if (flag) {
                        return true;
                    }
                    bottom = bottom.substring(0, bottom.length() - 1);
                }
            }
        }
        return false;
    }

    private Map<String, Integer> convert(List<String> allowed) {
        int[] nums = {1, 2, 4, 8, 16, 32, 64};
        Map<String, Integer> map = new HashMap<>();
        for (String allow : allowed) {
            int c = nums[allow.charAt(2) - 'A'];
            String key = allow.substring(0, 2);
            map.put(key, map.getOrDefault(key, 0) + c);
        }
        return map;
    }
}
