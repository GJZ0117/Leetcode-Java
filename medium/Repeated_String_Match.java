package medium;

/**
 * 686. Repeated String Match
 */

public class Repeated_String_Match {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        int ans = 1;
        while (sb.length() < b.length()) {
            sb.append(a);
            ans++;
        }
        sb.append(a);
        int index = sb.indexOf(b);
        if (index == -1) {
            return -1;
        }
        return index + b.length() > a.length() * ans ? ans + 1 : ans;
    }
}
