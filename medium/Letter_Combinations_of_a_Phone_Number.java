package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 */

public class Letter_Combinations_of_a_Phone_Number {

    public static void main(String[] args) {
        String digits = "9";
        List<String> list = letterCombinations(digits);
        System.out.println(list);
    }

    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0) return list;
        String[] chars = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder sb = new StringBuilder();
        combine(sb, digits, 0, list, chars);
        return list;
    }

    public static void combine(StringBuilder sb, String digits, int offset, List<String> list, String[] chars) {
        if (offset >= digits.length()) {
            list.add(sb.toString());
            return;
        }
        String letters = chars[digits.charAt(offset) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            combine(sb.append(letters.charAt(i)), digits, offset + 1, list, chars);
            sb.delete(sb.length() - 1, sb.length());
        }
    }

    // 二刷
    public List<String> letterCombinations_2(String digits) {
        List<String> res = new ArrayList<>();
        String[] chars = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        dfs(digits, 0, chars, res, new StringBuilder());
        return res;
    }

    public void dfs(String digits, int digitsIndex, String[] chars, List<String> res, StringBuilder sb) {
        if (digitsIndex == digits.length()) {
            if (sb.length() > 0){
                res.add(sb.toString());
            }
            return;
        }
        String nums = chars[digits.charAt(digitsIndex) - '0'];
        for (int i = 0; i < nums.length(); i++) {
            sb.append(nums.charAt(i));
            dfs(digits, digitsIndex + 1, chars, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
