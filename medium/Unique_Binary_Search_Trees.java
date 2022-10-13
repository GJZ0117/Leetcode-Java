package medium;

/**
 * 96. Unique Binary Search Trees
 */

public class Unique_Binary_Search_Trees {

    public static void main(String[] args) {
        System.out.println(numTrees(19));
    }

    //动态规划的思想，记录节点数为n时对应的BST个数
    public static int numTrees(int n) {
        if (n<=2) {
            return n;
        }

        int[] arr = new int[n+1]; //用于记录节点数为n时所对应的BST个数
        arr[1] = 1;
        arr[2] = 2;

        for (int i =3; i<=n; i++) {
            int temp = 2 * arr[i-1]; //当节点数为i时，以1和i为根节点的BST个数均为节点数为i-1时的BST个数
            for (int j=2; j<i; j++) { //当节点数i时根节点为为2~i-1的情况
                temp += arr[j-1] * arr[i-j]; //节点数为i时以j为根节点的BST种类为 左子树个数 * 右子树个数
            }
            arr[i] = temp;
        }

        return arr[n];
    }
}
