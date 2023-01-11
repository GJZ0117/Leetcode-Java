package medium;

/**
 * 481. Magical String
 */

public class Magical_String {
    public int magicalString(int n) {
        char[] s = new char[n + 2];
        s[0] = '1';
        s[1] = '2';
        s[2] = '2';
        int index = 3;
        char c = s[2];
        for (int i = 2; index < n; i++) {
            c = (c == '2' ? '1' : '2');
            s[index++] = c;
            if (s[i] == '2') {
                s[index++] = c;
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '1') {
                ans++;
            }
        }
        return ans;
    }
}
