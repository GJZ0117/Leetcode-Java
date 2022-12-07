package medium;

import java.util.*;

/**
 * 380. Insert Delete GetRandom O(1)
 */

public class RandomizedSet {
    Random random = new Random();
    Map<Integer, Integer> map = new HashMap<>();
    int[] nums = new int[200000];
    int numsIndex = 0;

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, numsIndex);
        nums[numsIndex++] = val;
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int pos = map.get(val);
        if (pos == numsIndex - 1) {
            numsIndex--;
        } else {
            nums[pos] = nums[numsIndex - 1];
            map.put(nums[numsIndex - 1], pos);
            numsIndex--;
        }
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return nums[random.nextInt(numsIndex)];
    }
}
