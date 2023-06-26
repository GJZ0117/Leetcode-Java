package medium;

/**
 * 955. Delete Columns to Make Sorted II
 */

public class Delete_Columns_to_Make_Sorted_II {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        int[] visited = new int[n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            boolean isDelete = false;
            for (int j = 1; j < n; j++) {
                if (visited[j] == 1) {
                    continue;
                }
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    isDelete = true;
                    break;
                }
            }
            if (isDelete) {
                ans++;
            } else {
                for (int j = 1; j < n; j++) {
                    if (strs[j].charAt(i) > strs[j - 1].charAt(i)) {
                        visited[j] = 1;
                    }
                }
            }
        }
        return ans;
    }
}
