package Finished;

public class BestTimeToBuyAndSellStocksIII {
	/**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length <= 1)
            return 0;
        int days = prices.length;
        int[] sellBefore = new int[days];
        int[] buyAfter = new int[days];
        int max = 0;
        int min = 0;
        for (int i = 0; i < days; ++i) {
            if (i == 0) {
                sellBefore[i] = 0;
                min = prices[i];
            }
            if (prices[i] - min > max)
                max = prices[i] - min;
            if (prices[i] < min)
                min = prices[i];
            sellBefore[i] = max;
        }
        max = 0;
        int maxSoFar = 0;
        for (int i = days - 1; i >= 0; --i) {
            if (i == 0) {
                buyAfter[i] = 0;
                max = prices[i];
            }
            if (max - prices[i] > maxSoFar)
                maxSoFar = max - prices[i];
            if (prices[i] > max)
                max = prices[i];
            buyAfter[i] = maxSoFar;
        }
        int result = 0;
        for (int i = 0; i < days; ++i)
            result = Math.max(result, sellBefore[i] + buyAfter[i]);
        return result;
    }
}
