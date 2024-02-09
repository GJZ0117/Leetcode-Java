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
    public ListNode mergeTwoLists_2(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode();
        ListNode cur = newHead;
        ListNode l1 = list1;
        ListNode l2 = list2;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (l1 != null) {
            cur.next = l1;
        } else if (l2 != null) {
            cur.next = l2;
        }
        return newHead.next;
    }
}
