package easy;

/**
 * 415. Add Strings
 */

public class Add_Strings {

    public static void main(String[] args) {
        String num1 = "999";
        String num2 = "9";
        System.out.println(addStrings(num1, num2));
    }

    public static String addStrings(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return num1.equals("0") ? num2 : num1;
        }

        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for (int i = num2.length() - 1; i >= 0; i--) {
            int index1 = i + (num1.length() - num2.length());
            int n1 = num1.charAt(index1) - '0';
            int n2 = num2.charAt(i) - '0';
            int cur = n1 + n2 + (flag ? 1 : 0);
            if (cur >= 10) {
                cur = cur % 10;
                flag = true;
            } else {
                flag = false;
            }
            sb.insert(0, cur);
        }

        for (int i = num1.length() - num2.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            int cur = n1 + (flag ? 1 : 0);
            if (cur >= 10) {
                cur = cur % 10;
                flag = true;
                sb.insert(0, cur);
            } else {
                flag = false;
                sb.insert(0, cur);
            }
        }
        if (flag) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }
}
