package medium;

/**
 * 912. Sort an Array
 */

public class Sort_an_Array {
    public int[] sortArray(int[] nums) {
        for (int i = (nums.length - 1) / 2; i >= 0; i--) {
            adjustHeap(nums, i, nums.length);
        }
        for (int i = nums.length - 1; i > 0; i--) {
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            adjustHeap(nums, 0, i);
        }
        return nums;
    }

    public void adjustHeap(int[] nums, int parent, int length) {
        int temp = nums[parent];
        int lChild = parent * 2 + 1;
        while (lChild < length) {
            int rChild = lChild + 1;
            if (rChild < length && nums[lChild] < nums[rChild]) {
                lChild++;
            }
            if (temp >= nums[lChild]) {
                break;
            }
            nums[parent] = nums[lChild];
            parent = lChild;
            lChild = 2 * lChild + 1;
        }
        nums[parent] = temp;
    }


    // 二刷
    public int[] sortArray_2(int[] nums) {
        for (int i = (nums.length - 1) / 2; i >= 0; i--) {
            adjustHeap_2(nums, i, nums.length);
        }
        for (int i = nums.length - 1; i > 0; i--) {
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            adjustHeap_2(nums, 0, i);
        }
        return nums;
    }

    public void adjustHeap_2(int[] nums, int parent, int length) {
        int temp = nums[parent];
        int lChild = parent * 2 + 1;
        while (lChild < length) {
            int rChild = lChild + 1;
            if (rChild < length && nums[lChild] < nums[rChild]) {
                lChild++;
            }
            if (temp >= nums[lChild]) {
                break;
            }
            nums[parent] = nums[lChild];
            parent = lChild;
            lChild = 2 * lChild + 1;
        }
        nums[parent] = temp;
    }
}
