package hard;

/**
 * 52. N-Queens II
 */

public class N_Queens_II {

    public static void main(String[] args) {
        N_Queens_II solution = new N_Queens_II();
        System.out.println(solution.totalNQueens(8));
    }

    public int totalNQueens(int n) {
        int[] count = {0};
        int[] array = new int[n];
        check(n, 0, array, count);
        return count[0];
    }

    private void check(int n, int cur, int[] array, int[] count) {
        if (cur == n) {
            count[0]++;
            return;
        }
        //依次放入皇后并判断是否冲突
        for (int i = 0; i < n; i++) {
            array[cur] = i; //先把当前这个皇后n放到该行的第1列
            //判断当放置第n个皇后到i列时是否冲突
            if (judge(cur, array)) { //不冲突
                check(n,cur + 1, array, count); //接着放第n+1个皇后，回溯
            }
            //如果冲突，就继续执行 array[n] = i; 即将第 n 个皇后，放置在本行得 后移的一个位置
        }
    }
    /**
     * 查看当放置第n个皇后检测该皇后是否和前面已经摆放的皇后冲突
     */
    public boolean judge(int cur, int[] array) {
        for (int i = 0; i < cur; ++i) {
            //1. array[i] == array[n] 表示判断 第 n 个皇后是否和前面的 n-1 个皇后在同一列
            //2. Math.abs(n-i) == Math.abs(array[n] - array[i]) 表示判断第 n 个皇后是否和第 i 皇后是否在同一斜线
            // n = 1 放置第 2 列  n = 1 array[1] = 1
            // Math.abs(1-0) == 1 Math.abs(array[n] - array[i]) = Math.abs(1-0) = 1
            //3. 判断是否在同一行, 没有必要，n 每次都在递增
            if (array[i] == array[cur] || Math.abs(cur - i) == Math.abs(array[cur] - array[i])) {
                return false;
            }
        }
        return true;
    }
}
