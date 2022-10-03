package BasicDataStructure.Recursion;

/**
 * 汉诺塔
 */
public class Hanoitower {

    public static void main(String[] args) {
        hanoiTower(5, 'A', 'B', 'C');
    }

    public static void hanoiTower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第一个盘从" + a + "->" + c);
        } else { //如果n>=2，可以看做是两个盘：1.最下边的一个盘 2. 上面的所有盘
            //先把最上面的所有盘A->B，移动过程会用到C
            hanoiTower(num - 1, a, c, b);
            //把最下面的盘A->C
            System.out.println("第" + num + "个盘从" + a + "->" + c);
            //把B塔的所有盘从B->C，移动过程会用到A
            hanoiTower(num - 1, b, a, c);
        }
    }
}
