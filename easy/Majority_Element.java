package easy;

/**
 * 169. Majority Element
 */

public class Majority_Element {
    public int majorityElement(int[] nums) {
        int temp = nums[0];
        int times = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == temp) {
                times++;
            }else {
                times--;
            }
            if (times == 0) {
                temp = nums[i];
                times = 1;
            }
        }
        return temp;
    }
}
