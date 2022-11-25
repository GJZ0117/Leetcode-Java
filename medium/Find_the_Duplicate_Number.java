package medium;

/**
 * 287. Find the Duplicate Number
 */

public class Find_the_Duplicate_Number {
    /**
     * eg:  4 -> 3 -> 1 -> 2 -> 2
     *            __________
     *           |         |
     *           V         |
     *      4 -> 2 -> 1 -> 3
     */
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (true) {
            slow = nums[slow]; // slow pointer move one step
            fast = nums[nums[fast]]; // fast pointer move two step
            if (slow == fast) { // the fast time when slow pointer meets fast pointer
                fast = 0; // reset fast pointer to the beginning of the nums
                while (true) {
                    if (slow == fast) { // if meet again, this is the enterance of circle
                        return slow;
                    }
                    slow = nums[slow]; //every time fast pointer and slow pointer move one step
                    fast = nums[fast];
                }
            }
        }
    }
}
