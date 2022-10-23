package medium;

/**
 * 38. Count and Say
 */

public class Count_and_Say {

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        for (int i = 2; i <= n; i++) {

            char[] preStr = sb.toString().toCharArray();
            sb.delete(0, sb.length());

            int j = 0;
            char temp;
            while (j < preStr.length) {
                int times = 1;
                temp = preStr[j++];
                while (j < preStr.length && preStr[j] == temp) {
                    j++;
                    times++;
                }
                sb.append(times);
                sb.append(temp);
            }
        }
        return sb.toString();
    }
}
