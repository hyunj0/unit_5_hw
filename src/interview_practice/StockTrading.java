package interview_practice;

public class StockTrading {

    public static void main(String[] args) {
        int[] stock_prices_yesterday = new int[] {10, 7, 5, 8, 11, 9};
        System.out.println(get_max_profit(stock_prices_yesterday));
    }

    //Used hint
    //The brute force approach would be to try every pair of times
    //(treating the earlier time as the buy time and the later time as the sell time) and see which one is higher.
    public static int get_max_profit(int[] stock_prices_yesterday) {
        int max_profit = Integer.MIN_VALUE;
        for (int i = 0; i < stock_prices_yesterday.length; i++) {
            for (int j = i+1; j < stock_prices_yesterday.length; j++) {
                int profit = stock_prices_yesterday[j] - stock_prices_yesterday[i];
                System.out.println("Index i = " + i + " , Index j = " + j + " , profit = " + profit);
                if (profit > max_profit) {
                    max_profit = profit;
                }
            }
        }
        return max_profit;
    }
}