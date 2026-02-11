import java.util.Arrays; 
 
class Solution { 
 
    public int maxProfit(int[] prices) { 
 
        int buy_price = prices[0]; 
        int profit = 0; 
 
        for (int i = 1; i < prices.length; i++) { 
 
            if (prices[i] < buy_price) { 
                buy_price = prices[i]; 
            } else { 
                profit = Math.max(profit, prices[i] - buy_price); 
            } 
        } 
        return profit; 
    }public static void main(String[] args) { 
        Solution s = new Solution(); 
        int[] prices = {7, 1, 5, 3, 6, 4}; 
 
        System.out.println(s.maxProfit(prices)); 
    } 
}