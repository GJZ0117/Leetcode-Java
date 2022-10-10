package hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 76. Minimum Window Substring
 */

public class Minimum_Window_Substring {

    public static void main(String[] args) {
        String s = "ebbancf";
        String t = "abc";
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
        t = sc.nextLine();
        System.out.println(minWindow(s, t));
    }


    /**
     * https://leetcode.cn/problems/minimum-window-substring/solution/hua-dong-chuang-kou-suan-fa-tong-yong-si-xiang-by-/
     * 在字符串 S 中使用双指针中的左右指针技巧，初始化 left = right = 0，把索引左闭右开区间 [left, right) 称为一个「窗口」
     * 先不断地增加 right 指针扩大窗口 [left, right)，直到窗口中的字符串符合要求（包含了 T 中的所有字符）
     * 此时，停止增加 right，转而不断增加 left 指针缩小窗口 [left, right)，直到窗口中的字符串不再符合要求（不包含 T 中的所有字符了）。同时，每次增加 left，我们都要更新一轮结果
     * 重复第 2 和第 3 步，直到 right 到达字符串 S 的尽头
     */
    public static String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (Character c : t.toCharArray()) {
            need.put(c, need.containsKey(c) ? need.get(c) + 1 : 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0; //表示窗口中满足 need 条件的字符个数

        int start = 0, len = Integer.MAX_VALUE; //记录最小覆盖子串的起始索引及长度

        while (right < s.length()) {
            Character c = s.charAt(right); //c 是将移入窗口的字符
            right++; //右移窗口

            if (need.containsKey(c)) { //进行窗口内数据更新
                window.put(c, window.containsKey(c) ? window.get(c) + 1 : 1);
                if (window.get(c).equals(need.get(c))) { //不能用==要用equals
                    valid++;
                }
            }

            while (valid == need.size()) { //判断左侧窗口是否要收缩
                if (right - left < len) { //更新最小覆盖子串
                    start = left;
                    len = right - left;
                }
                Character d = s.charAt(left); //移出窗口的字符
                left++; //左移窗口
                if (need.containsKey(d)) { //进行窗口内数据更新
                    if (window.get(d).equals(need.get(d))) { //不能用==要用equals
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        //返回最小覆盖子串
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
