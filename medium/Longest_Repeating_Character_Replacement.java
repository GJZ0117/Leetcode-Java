package medium;


/**
 * 424. Longest Repeating Character Replacement
 */

public class Longest_Repeating_Character_Replacement {
    /**
     * 右边界先移动找到一个满足题意的可以替换 k 个字符以后，所有字符都变成一样的当前看来最长的子串，直到右边界纳入一个字符以后，不能满足的时候停下；
     * 然后考虑左边界向右移动，左边界只须要向右移动一格以后，右边界就又可以开始向右移动了，继续尝试找到更长的目标子串；
     * 替换后的最长重复子串就产生在右边界、左边界交替向右移动的过程中。
     */
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26]; //26个大写英文字母
        int left = 0;
        int right = 0;
        int maxCount = 0;
        int res = 0;
        // [left, right) 内最多替换 k 个字符可以得到只有一种字符的子串
        while (right < s.length()) {
            int curChar = s.charAt(right) - 'A';
            arr[curChar]++;
            // 在这里维护 maxCount，因为每一次右边界读入一个字符，字符频数增加，才会使得 maxCount 增加
            maxCount = Math.max(maxCount, arr[curChar]);
            right++;

            if (right - left > maxCount + k) {
                // 说明此时 k 不够用
                // 把其它不是最多出现的字符替换以后，都不能填满这个滑动的窗口，这个时候须要考虑左边界向右移动
                // 移出滑动窗口的时候，频数数组须要相应地做减法
                int delChar = s.charAt(left) - 'A';
                arr[delChar]--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}