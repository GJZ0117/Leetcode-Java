package hard;


/**
 * 41. First Missing Positive
 */

public class First_Missing_Positive {

    public static void main(String[] args) {
        int[] nums = {2};
        System.out.println(firstMissingPositive(nums));
    }

    /**
     * Put each number in its right place.
     * 注意：把1放到索引为0的位置，2放到索引为1的位置...（如果1放1，在某些情况比如[1]或[2],在第二个for循环很难判断）
     * https://leetcode.com/problems/first-missing-positive/discuss/17071/My-short-c%2B%2B-solution-O(1)-space-and-O(n)-time
     */

    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] < nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
