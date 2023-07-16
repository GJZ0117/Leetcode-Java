package medium;

/**
 * 985. Sum of Even Numbers After Queries
 */

public class Sum_of_Even_Numbers_After_Queries {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n = queries.length;
        int[] res = new int[n];
        int evenSum = 0;
        for (int num : nums) {
            if (Math.abs(num % 2) == 0) {
                evenSum = evenSum + num;
            }
        }

        for (int i = 0; i < n; i++) {
            int index = queries[i][1];
            int val = queries[i][0];
            if (Math.abs(nums[index] % 2) == 0) {
                if (Math.abs(val % 2) == 1) {
                    evenSum = evenSum - nums[index];
                } else {
                    evenSum = evenSum + val;
                }
                nums[index] = nums[index] + val;
            } else if (Math.abs(nums[index] % 2) == 1 && Math.abs(val % 2) == 1) {
                nums[index] = nums[index] + val;
                evenSum = evenSum + nums[index];
            } else {
                nums[index] = nums[index] + val;
            }
            res[i] = evenSum;
        }
        return res;
    }
}
