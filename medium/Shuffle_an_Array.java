package medium;

import java.util.Random;

/**
 * 384. Shuffle an Array
 */

public class Shuffle_an_Array {
    class Solution {

        int[] basic;
        int[] changed;
        Random random;

        public Solution(int[] nums) {
            basic = nums;
            random = new Random();
        }

        public int[] reset() {
            return basic;
        }

        public int[] shuffle() {
            changed = basic.clone();
            for (int i = 0; i < changed.length; i++) {
                swap(changed, i, i + random.nextInt(changed.length - i));
            }
            return changed;
        }

        void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
