package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. Summary Ranges
 */

public class Summary_Ranges {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }else if (nums.length == 1){
            list.add(String.valueOf(nums[0]));
            return list;
        }
        int start = nums[0];
        int end = nums[0];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < nums.length; i++) {
            end = nums[i - 1];
            if (nums[i] - 1 == nums[i - 1]) {
                continue;
            } else {
                if (start == end) {
                    list.add(String.valueOf(start));
                    start = nums[i];
                } else {
                    sb.append(start);
                    sb.append("->");
                    sb.append(end);
                    list.add(sb.toString());
                    sb.delete(0, sb.length());
                    start = nums[i];
                }
            }
        }

        if (start > end) {
            list.add(String.valueOf(start));
        } else {
            sb.append(start);
            sb.append("->");
            sb.append(nums[nums.length - 1]);
            list.add(sb.toString());
        }
        return list;
    }
}
