package easy;

import java.util.LinkedList;
import java.util.List;

/**
 * 482. License Key Formatting
 */

public class License_Key_Formatting {

    public static void main(String[] args) {
        String s = "2-5g-3-J";
        int k = 1;
        System.out.println(licenseKeyFormatting(s, k));
    }

    public static String licenseKeyFormatting(String s, int k) {
        s = s.toUpperCase();
        String[] strs = s.split("-");
        List<String> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            String curStr = strs[i];
            int diff = sb.length() + curStr.length() - k;
            System.out.print(curStr + " ");
            if (diff == 0) {
                System.out.println("==");
                addConvertedCharacter(sb, curStr, 0, curStr.length() - 1);
                list.add(0, sb.toString());
                sb.delete(0, sb.length());
            } else if (diff < 0) {
                System.out.println("<");
                addConvertedCharacter(sb, curStr, 0, curStr.length() - 1);
            } else if (diff > 0) {
                System.out.println(">");
                int end = curStr.length() - 1;
                while (diff >= 0) {
                    addConvertedCharacter(sb, curStr, diff, end);
                    list.add(0, sb.toString());
                    sb.delete(0, sb.length());
                    end = diff - 1;
                    diff -= k;
                }

                if (end >= 0) {
                    addConvertedCharacter(sb, curStr, 0, end);
                }
            }
        }

        if (sb.length() != 0) {
            list.add(0, sb.toString());
            sb.delete(0, sb.length());
        }
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size() - 1) {
                sb.append("-");
            }
        }
        return sb.toString();
    }

    public static void addConvertedCharacter(StringBuilder sb, String str, int start, int end) {
        for (int i = end; i >= start; i--) {
            char c = str.charAt(i);
            sb.insert(0, c);
        }
    }
}
