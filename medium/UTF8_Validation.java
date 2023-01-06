package medium;

/**
 * 393. UTF-8 Validation
 */

public class UTF8_Validation {

    public static void main(String[] args) {
        int[] data = {228, 189, 160, 229, 165, 189, 13, 10};
        System.out.println(validUtf8(data));
    }

    public static boolean validUtf8(int[] data) {
        int index = 0;
        while (index < data.length) {
            int firstByte = data[index];
            int utf8Len = getUTF8Len(firstByte);
            if (utf8Len == -1) {
                return false;
            } else if (utf8Len == 1) {
                index++;
            } else {
                int i = index + 1;
                while (i < data.length && i < utf8Len + index) {
                    if ((((data[i] >> 7) & 1) != 1) || (((data[i] >> 6) & 1) != 0)) {
                        return false;
                    }
                    i++;
                }
                if (i != index + utf8Len) {
                    return false;
                }
                index = i;
            }
        }
        return true;
    }

    public static int getUTF8Len(int firstByte) {
        if (((firstByte >> 7) & 1) == 0) {
            return 1;
        } else if (((firstByte >> 6) & 1) == 1 && ((firstByte >> 7) & 1) == 1) {
            if (((firstByte >> 5) & 1) == 0) {
                return 2;
            } else if (((firstByte >> 4) & 1) == 0) {
                return 3;
            } else if (((firstByte >> 3) & 1) == 0) {
                return 4;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }
}
