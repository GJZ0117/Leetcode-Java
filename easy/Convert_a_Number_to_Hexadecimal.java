package easy;

/**
 * 405. Convert a Number to Hexadecimal
 */

public class Convert_a_Number_to_Hexadecimal {
    public String toHex(int num) {
        char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder();
        while (sb.length() < 8) {
            sb.append(chars[num & 0xf]);
            num >>= 4;
            if (num == 0) {
                break;
            }
        }
        return sb.reverse().toString();
    }
}
