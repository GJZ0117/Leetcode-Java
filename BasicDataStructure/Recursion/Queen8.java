package BasicDataStructure.Recursion;

/**
 * 八皇后问题，是一个古老而著名的问题，是回溯算法的典型案例。该问题是国际西洋棋棋手马克斯·贝瑟尔于
 * 1848 年提出：在 8×8 格的国际象棋上摆放八个皇后，使其不能互相攻击，即： 任意两个皇后都不能处于同一行 、
 * 同一列或同一斜线上，问有多少种摆法(92)
 * <p>
 * 理论上应该创建一个二维数组来表示棋盘，但是实际上可以通过算法，用一个一维数组即可解决问题. arr[8] =
 * {0 , 4, 7, 5, 2, 6, 1, 3} //对应 arr 下标 表示第几行，即第几个皇后，arr[i] = val , val 表示第 i+1 个皇后，放在第 i+1
 * 行的第 val+1 列
 */
public class Queen8 {
    int max = 8; //max表示共有多少个皇后
    int[] array = new int[max]; //保存皇后存放的位置的结果
    static int count = 0;
    static int judgeCount = 0;

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println("一共有 " + count + " 种解法");
        System.out.println("一共判断冲突的次数: " + judgeCount); // 1.5w
    }

    /**
     * 编写方法放置第n个皇后
     */
    private void check(int n) {
        if (n == max) { //n = 8 , 其实 8 个皇后就既然放好
            print();
            return;
        }

        //依次放入皇后并判断是否冲突
        for (int i = 0; i < max; i++) {
            array[n] = i; //先把当前这个皇后n放到该行的第1列
            //判断当放置第n个皇后到i列时是否冲突
            if (judge(n)) { //不冲突
                check(n + 1); //接着放第n+1个皇后，回溯
            }
            //如果冲突，就继续执行 array[n] = i; 即将第 n 个皇后，放置在本行得 后移的一个位置
        }
    }

    /**
     * 查看当放置第n个皇后检测该皇后是否和前面已经摆放的皇后冲突
     */
    public boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; ++i) {
            //1. array[i] == array[n] 表示判断 第 n 个皇后是否和前面的 n-1 个皇后在同一列
            //2. Math.abs(n-i) == Math.abs(array[n] - array[i]) 表示判断第 n 个皇后是否和第 i 皇后是否在同一斜线
            // n = 1 放置第 2 列  n = 1 array[1] = 1
            // Math.abs(1-0) == 1 Math.abs(array[n] - array[i]) = Math.abs(1-0) = 1
            //3. 判断是否在同一行, 没有必要，n 每次都在递增
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 将皇后摆放的位置输出
     */
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
