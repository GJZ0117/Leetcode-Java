package medium;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 833. Find And Replace in String
 */

public class Find_And_Replace_in_String {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        sort(indices, sources, targets);
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < indices.length; i++) {
            int startIndex = indices[i];
            String sourceStr = sources[i];
            boolean flag = true;
            for (int j = startIndex; j - startIndex < sourceStr.length(); j++) {
                if (j >= s.length() || sourceStr.charAt(j - startIndex) != s.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                set.add(i);
            }
        }

        int offset = 0;
        StringBuilder sb = new StringBuilder(s);
        for (int i : set) {
            int startIndex = indices[i];
            String sourceStr = sources[i];
            String targetStr = targets[i];
            sb.delete(offset + startIndex, offset + startIndex + sourceStr.length());
            sb.insert(offset + startIndex, targetStr);
            offset += targetStr.length() - sourceStr.length();
        }
        return sb.toString();
    }

    private void sort(int[] indices, String[] sources, String[] targets) {
        for (int i = 0; i < indices.length - 1; i++) {
            for (int j = 0; j < indices.length - 1; j++) {
                if (indices[j] > indices[j + 1]) {
                    int tempIndices = indices[j];
                    String tempSource = sources[j];
                    String tempTarget = targets[j];
                    indices[j] = indices[j + 1];
                    sources[j] = sources[j + 1];
                    targets[j] = targets[j + 1];
                    indices[j + 1] = tempIndices;
                    sources[j + 1] = tempSource;
                    targets[j + 1] = tempTarget;
                }
            }
        }
    }
}
