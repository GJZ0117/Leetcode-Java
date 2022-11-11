package hard;

/**
 * 123. Best Time to Buy and Sell Stock III
 */

public class Best_Time_to_Buy_and_Sell_Stock_III {

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(prices));
    }


    //https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/solution/xiao-bai-tong-su-yi-dong-de-jie-fa-by-clark-12/
    public static int maxProfit(int[] prices) {
        int buy_1 = Integer.MAX_VALUE;
        int buy_2 = Integer.MAX_VALUE;
        int profit_1 = 0;
        int profit_2 = 0;
        for (int p : prices) {
            buy_1 = Math.min(buy_1, p); // the first stock's cost
            profit_1 = Math.max(profit_1, p - buy_1); // the first stock's profit
            buy_2 = Math.min(buy_2, p - profit_1); // when we buy the second stock, we have already bought and sold the first stock, so the second stock's cost is (price - profit_1)
            profit_2 = Math.max(profit_2, p - buy_2); // the total stocks' profits are (price - buy_2)
        }
        return profit_2;
    }
}
