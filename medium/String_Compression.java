package medium;

/**
 * 443. String Compression
 */

public class String_Compression {
    public int compress(char[] chars) {
        int curLen = 1;
        char preChar = chars[0];
        int index = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != preChar) {
                if (curLen == 1) {
                    chars[index++] = preChar;
                } else {
                    chars[index++] = preChar;
                    int start = index;
                    while (curLen != 0) {
                        chars[index++] = (char) (curLen % 10 + '0');
                        curLen /= 10;
                    }
                    convert(chars, start, index - 1);
                }
                preChar = chars[i];
                curLen = 1;
            } else {
                curLen++;
            }
        }

        if (curLen == 1) {
            chars[index++] = preChar;
        } else {
            chars[index++] = preChar;
            int start = index;
            while (curLen != 0) {
                chars[index++] = (char) (curLen % 10 + '0');
                curLen /= 10;
            }
            convert(chars, start, index - 1);
        }

        return index;
    }

    private void convert(char[] chars, int start, int end) {
        char temp;
        while (start<end) {
            temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
