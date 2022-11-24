package medium;

import java.util.Arrays;

/**
 * 274. H-Index
 */

public class H_Index {

    public static void main(String[] args) {
        int[] citations = {1, 3, 1};
        System.out.println(hIndex(citations));
    }

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int h = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (citations[i] > h) {
                h++;
            } else {
                break;
            }
        }
        return h;
    }
}
