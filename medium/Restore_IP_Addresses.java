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
}
