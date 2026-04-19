class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1; // acts like infinity
        int[] dp = new int[amount + 1];

        // Initialize dp array
        for (int i = 0; i <= amount; i++) {
            dp[i] = max;
        }
        dp[0] = 0;

        // Fill dp
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}