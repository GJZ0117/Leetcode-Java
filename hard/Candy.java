package hard;

/**
 * 135. Candy
 */

public class Candy {

    public static void main(String[] args) {
        int[] ratings = {1, 2, 2};
        System.out.println(candy(ratings));
    }

    //https://leetcode.cn/problems/candy/solution/candy-cong-zuo-zhi-you-cong-you-zhi-zuo-qu-zui-da-/
    public static int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        int candyNum = 0;
        for (int i = 0; i < ratings.length; i++) { // initialize array left and right (at least give each child one cindy)
            left[i] = 1;
            right[i] = 1;
        }
        for (int i = 1; i < ratings.length; i++) { // traverse array left from left to right
            if (ratings[i] > ratings[i - 1]) { // if rating(i) > rating(i-1), left(i) = left(i-1) + 1
                left[i] = left[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) { // traverse array right from right to left
            if (ratings[i] > ratings[i + 1]) { // if rating(i) > rating(i+1), right(i) = right(i+1) + 1
                right[i] = right[i + 1] + 1;
            }
        }
        for (int i = 0; i < ratings.length; i++) { // chid i's candy num is max(left(i), right(i))
            candyNum += Math.max(left[i], right[i]);
        }
        return candyNum;
    }
}
