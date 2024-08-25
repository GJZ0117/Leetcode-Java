package easy;

/**
 * 121. Best Time to Buy and Sell Stock
 */

public class Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        } else if (prices.length == 2) {
            return prices[1] > prices[0] ? (prices[1] - prices[0]) : 0;
        }

        int min = prices[0];
        int maxDiff = prices[1] - min;
        int curDiff;
        for (int i = 2; i < prices.length; i++) {
            if (prices[i - 1] < min) {
                min = prices[i - 1];
            }
            curDiff = prices[i] - min;
            if (curDiff > maxDiff) {
                maxDiff = curDiff;
            }
        }
        return Math.max(maxDiff, 0);
    }


    // 二刷
    public int maxProfit_2(int[] prices) {
        int cost = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            cost = Math.min(price, cost);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}
