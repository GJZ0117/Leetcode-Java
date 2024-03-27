package medium;

/**
 * 875. Koko Eating Bananas
 */

public class Koko_Eating_Bananas {
    public int minEatingSpeed(int[] piles, int h) {
        int maxVal = 1;
        for (int pile : piles) {
            maxVal = Math.max(maxVal, pile);
        }
        int left = 1;
        int right = maxVal;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (calculateSum(piles, mid) > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int calculateSum(int[] piles, int speed) {
        int sum = 0;
        for (int pile : piles) {
            sum += (pile + speed - 1) / speed;
        }
        return sum;
    }


    // 二刷
    // https://leetcode.cn/problems/koko-eating-bananas/solutions/51963/er-fen-cha-zhao-ding-wei-su-du-by-liweiwei1419/
    public int minEatingSpeed_2(int[] piles, int h) {
        int maxVal = 1;
        for (int pile : piles) {
            maxVal = Math.max(maxVal, pile);
        }
        int left = 1;
        int right = maxVal;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (calculateSum_2(piles, mid) > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int calculateSum_2(int[] piles, int speed) {
        int sum = 0;
        for (int pile : piles) {
            sum += pile % speed == 0 ? pile / speed : pile / speed + 1;
        }
        return sum;
    }
}
