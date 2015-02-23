package Finished;

public class BestTimeToBuyAndSellStocksII {

	/**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        int result = 0;
        if (prices == null || prices.length < 2)
            return result;
        for (int i = 1; i < prices.length; ++i) {
            int val = prices[i] - prices[i - 1];
            if (val > 0)
                result += val;
        }
        return result;
    }
}
