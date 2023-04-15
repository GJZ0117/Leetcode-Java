package medium;

import java.util.Arrays;

/**
 * 825. Friends Of Appropriate Ages
 */

public class Friends_Of_Appropriate_Ages {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int left = 0;
        int right = 0;
        int ans = 0;
        for (int age : ages) {
            if (age <= 14) {
                continue;
            }
            while (ages[left] <= 0.5 * age + 7) {
                left++;
            }
            while (right + 1 < ages.length && ages[right + 1] <= age) {
                right++;
            }
            ans += right - left;
        }
        return ans;
    }
}
