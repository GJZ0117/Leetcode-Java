package medium;

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
                for (int k = sb.length() - move - 1; k >= 0 && !tempSb.isEmpty(); k--) {
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

                int index = tempSb.length()-1;
                while (tempFlag != 0 && index >= 0) {
                    int changeNum = Integer.parseInt(String.valueOf(tempSb.charAt(index)));
                    changeNum = changeNum + tempFlag;
                    if (changeNum > 9) {
                        tempFlag = changeNum / 10;
                        changeNum = changeNum % 10;
                    }else {
                        tempFlag = 0;
                    }
                    tempSb.replace(index, index+1, String.valueOf(changeNum));
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
}
