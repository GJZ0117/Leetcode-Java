package medium;


import java.util.Arrays;

/**
 * 179. Largest Number
 */

public class Largest_Number {

    public static void main(String[] args) {
        int[] nums = {10, 2};
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        // bubble sort
        String temp;
        boolean flag = false;
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs.length - i - 1; j++) {
                int res = compare(strs[j], strs[j + 1]);
                if (res == 1) {
                    flag = true;
                    temp = strs[j];
                    strs[j] = strs[j + 1];
                    strs[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
        //connect strings
        boolean zeroFlag = false; //check if only contains zeros
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            if (!s.equals("0")) {
                flag = true;
            }
            sb.append(s);
        }

        if (!flag) {
            return "0";
        } else {
            return sb.toString();
        }
    }

    // if s1 should be put in front of s2, return -1; else if s1 should be put at the end of s2, return 1
    public static int compare(String s1, String s2) {
        String s1AndS2 = s1 + s2;
        String s2AndS1 = s2 + s1;
        int len = s1AndS2.length();
        for (int i = 0; i < len; i++) {
            int diff = s1AndS2.charAt(i) - s2AndS1.charAt(i);
            if (diff > 0) {
                return -1;
            } else if (diff < 0) {
                return 1;
            }
        }
        return 1; // s1 + s2 equals s2 + s1, return 1 or -1
    }


    // 二刷（还不会）
    public String largestNumber_2(int[] nums) {
        String[] s = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s[i] = String.valueOf(nums[i]);
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(s, (a, b) -> (b + a).compareTo(a + b));
        Arrays.stream(s).forEach(e -> sb.append(e));
        String res = sb.toString();
        return res.startsWith("0") ? "0" : res;
    }
}
