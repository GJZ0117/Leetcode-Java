package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. Restore IP Addresses
 */

public class Restore_IP_Addresses {

    public static void main(String[] args) {
        String s = "101023";
        System.out.println(restoreIpAddresses(s));
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);
        dfs(ans, sb, 1, 0);
        return ans;
    }

    public static void dfs(List<String> ans, StringBuilder sb, int index, int pointNum) {
        if (pointNum == 3) {
            String[] strs = sb.toString().split("\\.");
            for (String str : strs) {
                if (str.length() > 3 || str.length() < 1 || (str.charAt(0) == '0' && str.length() > 1)) {
                    return;
                }
                int n = Integer.parseInt(str);
                if (n > 255) {
                    return;
                }
            }
            ans.add(sb.toString());
        }

        for (int i = index; i < sb.length(); i++) {
            sb.insert(i, ".");
            dfs(ans, sb, i + 2, pointNum + 1);
            sb.deleteCharAt(i);
        }
    }


    // 二刷（还不会）
    public List<String> restoreIpAddresse_2(String s) {
        List<String> list = new ArrayList<>();
        int n = s.length();
        for (int i = 0; i < 4 && i < n; i++) {
            for (int j = i + 1; j < i + 4 && j < n; j++) {
                for (int k = j + 1; k < j + 4 && k < n; k++) {
                    String segment1 = s.substring(0, i);
                    String segment2 = s.substring(i, j);
                    String segment3 = s.substring(j, k);
                    String segment4 = s.substring(k);
                    if (check(segment1) && check(segment2) && check(segment3) && check(segment4)) {
                        list.add(segment1 + "." + segment2 + "." + segment3 + "." + segment4);
                    }
                }
            }
        }
        return list;
    }

    private boolean check(String s) {
        return s.length() <= 3 && s.length() != 0 && (s.charAt(0) != '0' || s.length() <= 1) && Integer.parseInt(s) <= 255;
    }
}
