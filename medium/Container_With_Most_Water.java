package medium;

/**
 * 11. Container With Most Water
 */

public class Container_With_Most_Water {
    //思路：先考虑整个首尾两位置，因为它俩宽度最大；装水量最大值取决于两个边界元素的较小值，所以遍历其他位置的元素位置时，先舍弃已知边界的中的较小值并移动该指针
    //O(n)
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int water = 0;
        while (i < j) {
            water = Math.max(water, Math.min(height[i], height[j]) * (j - i));
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return water;
    }

    // 二刷
    public int maxArea_2(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            maxWater = Math.max(maxWater, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }
}
