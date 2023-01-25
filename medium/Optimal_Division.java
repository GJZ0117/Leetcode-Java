package medium;

/**
 * 553. Optimal Division
 */

public class Optimal_Division {
    public String optimalDivision(int[] nums) {
        int n = nums.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(nums[i]);
            if (i < n - 1) {
                sb.append("/");
            }
        }
        if (n > 2) {
            sb.insert(sb.indexOf("/") + 1, "(");
            sb.append(")");
        }
        return sb.toString();
    }
}
