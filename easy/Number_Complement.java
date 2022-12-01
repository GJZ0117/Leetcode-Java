package easy;

/**
 * 476. Number Complement
 */

public class Number_Complement {

    public static void main(String[] args) {
        int num = 2147483647;
        System.out.println(findComplement(num));
    }

    public static int findComplement(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 31; i++) {
            int bit = 1 & (num >> i);
            sb.insert(0, 1 - bit);
        }
        String str = sb.toString();

        int end = 0;
        while (end < str.length() && str.charAt(end) == '1') {
            end++;
        }

        int ans = 0;
        int times = 0;
        for (int i = 30; i >= end; i--) {
            if (str.charAt(i) == '1') {
                ans += (int) Math.pow(2, times);
            }
            times++;
        }
        return ans;
    }
}
