package easy;

/**
 * 944. Delete Columns to Make Sorted
 */

public class Delete_Columns_to_Make_Sorted {
    public int minDeletionSize(String[] strs) {
        int n = strs[0].length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            char curChar = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (curChar - strs[j].charAt(i) > 0) {
                    ans++;
                    break;
                }
                curChar = strs[j].charAt(i);
            }
        }
        return ans;
    }
}
