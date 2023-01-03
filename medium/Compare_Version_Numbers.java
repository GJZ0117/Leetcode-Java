package medium;

/**
 * 165. Compare Version Numbers
 */

public class Compare_Version_Numbers {
    public int compareVersion(String version1, String version2) {
        String[] strs1 = version1.split("\\.");
        String[] strs2 = version2.split("\\.");
        int minLen = Math.min(strs1.length, strs2.length);

        for (int i = 0; i < minLen; i++) {
            int v1 = Integer.parseInt(strs1[i]);
            int v2 = Integer.parseInt(strs2[i]);
            if (v1 > v2) {
                return 1;
            } else if (v2 > v1) {
                return -1;
            }
        }

        if (strs1.length != minLen) {
            int index = minLen;
            while (index < strs1.length) {
                int v1 = Integer.parseInt(strs1[index]);
                if (v1 > 0) {
                    return 1;
                }
                index++;
            }
        } else if (strs2.length != minLen) {
            int index = minLen;
            while (index < strs2.length) {
                int v2 = Integer.parseInt(strs2[index]);
                if (v2 > 0) {
                    return -1;
                }
                index++;
            }
        }

        return 0;
    }
}
