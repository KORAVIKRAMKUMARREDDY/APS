import java.util.*;

class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = Arrays.copyOf(prices, n);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int idx = stack.pop();
                ans[idx] -= prices[i];
            }
            stack.push(i);
        }

        return ans;
    }
}
