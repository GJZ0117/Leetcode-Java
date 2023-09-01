package medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 43. Multiply Strings
 */

public class Multiply_Strings {

    public static void main(String[] args) {
        String num1 = "999";
        String num2 = "99";
        System.out.println(multiply(num1, num2));
    }

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        if (num1.length() < num2.length()) { // make sure num2 is shorter than num1
            String tempStr = num1;
            num1 = num2;
            num2 = tempStr;
        }

        int cur;
        int i;
        int move = 0;

        for (i = num2.length() - 1; i >= 0; i--) {
            int n2 = Integer.parseInt(String.valueOf(num2.charAt(i)));
            int flag = 0;
            StringBuilder tempSb = new StringBuilder();

            for (int j = num1.length() - 1; j >= 0; j--) {
                int n1 = Integer.parseInt(String.valueOf(num1.charAt(j)));
                cur = flag + n1 * n2;
                if (cur > 9) {
                    flag = cur / 10;
                    cur = cur % 10;
                } else {
                    flag = 0;
                }
                tempSb.insert(0, cur);
            }
            if (flag != 0) {
                tempSb.insert(0, flag);
            }

            if (sb.length() == 0) {
                sb.append(tempSb);
            } else {
                int tempFlag = 0;
                for (int k = sb.length() - move - 1; k >= 0 && tempSb.length() != 0; k--) {
                    int add1 = Integer.parseInt(String.valueOf(tempSb.charAt(tempSb.length() - 1)));
                    tempSb.deleteCharAt(tempSb.length() - 1);
                    int add2 = Integer.parseInt(String.valueOf(sb.charAt(k)));
                    int ans = add1 + add2 + tempFlag;
                    if (ans > 9) {
                        tempFlag = ans / 10;
                        ans = ans % 10;
                    } else {
                        tempFlag = 0;
                    }
                    sb.replace(k, k + 1, String.valueOf(ans));
                }

                int index = tempSb.length() - 1;
                while (tempFlag != 0 && index >= 0) {
                    int changeNum = Integer.parseInt(String.valueOf(tempSb.charAt(index)));
                    changeNum = changeNum + tempFlag;
                    if (changeNum > 9) {
                        tempFlag = changeNum / 10;
                        changeNum = changeNum % 10;
                    } else {
                        tempFlag = 0;
                    }
                    tempSb.replace(index, index + 1, String.valueOf(changeNum));
                    index--;
                }
                if (tempFlag != 0) {
                    tempSb.insert(0, tempFlag);
                }

                tempSb.reverse();
                for (char c : tempSb.toString().toCharArray()) {
                    sb.insert(0, String.valueOf(c));
                }
            }
            move++;
        }

        return sb.toString();
    }


    // 二刷
    public String multiply_2(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = num2.length() - 1; i >= 0; i--) {
            int add = 0;
            int n2 = num2.charAt(i) - '0';
            if (n2 == 0) {
                continue;
            }

            for (int j = num1.length() - 1; j >= 0; j--) {
                int n1 = num1.charAt(j) - '0';
                int n = n1 * n2 + add;
                if (n > 9) {
                    add = n / 10;
                    n = n % 10;
                } else {
                    add = 0;
                }
                sb.insert(0, n);
            }
            if (add != 0) {
                sb.insert(0, add);
            }
            sb.append("0".repeat(num2.length() - i - 1));

            list.add(sb.toString());
            sb.delete(0, sb.length());
        }

        System.out.println(list);

        int add = 0;
        for (int i = 0; !list.isEmpty() && i < list.get(list.size() - 1).length(); i++) {
            int n = 0;

            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                String str = iterator.next();
                if (i >= str.length()) {
                    iterator.remove();
                    continue;
                }
                n += str.charAt(str.length() - i - 1) - '0';
            }

            n += add;
            if (n > 9) {
                add = n / 10;
                n %= 10;
            } else {
                add = 0;
            }
            sb.insert(0, n);
        }
        if (add != 0) {
            sb.insert(0, add);
        }
        return sb.toString();
    }
}
