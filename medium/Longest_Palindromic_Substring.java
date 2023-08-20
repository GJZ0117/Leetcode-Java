package medium;

/**
 * 5. Longest Palindromic Substring
 */

public class Longest_Palindromic_Substring {

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        //滑动窗口的思想，窗口长度递减，用双指针扫描窗口里的字符进行对比
        int window = s.length(); //窗口大小
        int i, j; //双指针，i为左指针，j为右指针
        boolean flag = true; //记录在窗口内遍历时i、j对应的字符是否相同
        for (; window > 0; window--) { //窗口由大到小长度递减
            int offset = s.length() - window; //固定一个窗口大小后，每轮遍历窗口时候的偏移
            for (i = 0, j = window - 1; i <= offset; i++, j++) { //确定窗口大小后，对偏移量进行遍历
                int temp = i; //用于暂存i，便于后续返回回文串时记录窗口的起始位置
                while (i < j) { //固定一个窗口的大小和偏移后，对窗口内的字符串用双指针遍历
                    if (s.charAt(i) != s.charAt(j)) {
                        flag = false;
                        break;
                    }
                    i++;
                    j--;
                }
                if (flag) { //是最长的回文串
                    return s.substring(temp, temp + window);
                } else { //不是最长的回文串，i、j、flag复原
                    i = temp;
                    j = temp + window - 1;
                    flag = true;
                }
            }
        }
        return s.substring(0, 1); //最长回文串长度为1直接返回第一个字符
    }

    // 二刷
    public String longestPalindrome_2(String s) {
        int windowLength = s.length();
        int offset = 0;
        while (windowLength > 1) {
            offset = s.length() - windowLength;
            while (offset >= 0) {
                int left = offset;
                int right = offset + windowLength - 1;
                boolean flag = true;
                while (left < right) {
                    if (s.charAt(left) != s.charAt(right)) {
                        flag = false;
                        break;
                    }
                    left++;
                    right--;
                }
                if (flag) {
                    return s.substring(offset, offset + windowLength);
                }
                offset--;
            }
            windowLength--;
        }
        return s.substring(0, 1);
    }
}
