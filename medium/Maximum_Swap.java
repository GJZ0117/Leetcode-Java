package medium;

/**
 * 670. Maximum Swap
 */

public class Maximum_Swap {
    public int maximumSwap(int num) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        for (int i = 0; i < sb.length() - 1; i++) {
            int num1 = Integer.parseInt(String.valueOf(sb.charAt(i)));
            int swapNum = num1;
            int swapIndex = i + 1;
            for (int j = i + 1; j < sb.length(); j++) {
                int num2 = Integer.parseInt(String.valueOf(sb.charAt(j)));
                if (num2 > num1 && num2 >= swapNum) {
                    swapNum = num2;
                    swapIndex = j;
                }
            }
            if (swapNum > num1) {
                sb.deleteCharAt(i);
                sb.insert(i, swapNum);
                sb.deleteCharAt(swapIndex);
                sb.insert(swapIndex, num1);
                break;
            }
        }
        return Integer.parseInt(sb.toString());
    }
}
