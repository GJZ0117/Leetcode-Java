package easy;

/**
 * 67. Add Binary
 */

public class Add_Binary {

    public static void main(String[] args) {
        System.out.println(addBinary("1011", "1001"));
    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int flag = 0; //进位

        while (i >= 0 || j >= 0) {
            int sum = flag; //当前位sum接收前一位的进位
            if (i >= 0) { //a没遍历完
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) { //b没遍历完
                sum += b.charAt(j) - '0';
                j--;
            }
            sb.append(sum % 2); //sb添加当前位的结果
            flag = sum / 2; //flag判断是否有进位
        }
        if (flag != 0) { //遍历到第一位后仍有进位，需要再添加一个1
            sb.append(flag);
        }
        return sb.reverse().toString();
    }
}
