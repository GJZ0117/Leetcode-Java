package easy;

/**
 * 645. Set Mismatch
 */

public class Set_Mismatch {
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        boolean[] flag = new boolean[nums.length + 1];
        for (int num : nums) {
            if (!flag[num]) {
                flag[num] = true;
            } else {
                ans[0] = num;
            }
        }
        for (int i = 1; i < flag.length; i++) {
            if (!flag[i]) {
                ans[1] = i;
                return ans;
            }
        }
        return ans;
    }
}
