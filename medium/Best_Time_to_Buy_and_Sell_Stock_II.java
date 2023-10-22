package medium;

/**
 * 122. Best Time to Buy and Sell Stock II
 */

public class Best_Time_to_Buy_and_Sell_Stock_II {

    public static void main(String[] args) {
        int[] prices = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int maxProfit = 0;
        int pre = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int cur = prices[i];
            if (cur > pre) { // when current value > previous value, add the difference
                maxProfit += (cur - pre);
            }
            pre = cur; // we can buy the stock at the same day when we sold it, or if previous value is higher than current value, we can buy it today
        }
        return maxProfit;
    }


    // 二刷（还不会）
    public int maxProfit_2(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
