class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] freeCount = new int[n];

        // Count how many other items j have factor[j] divisible by factor[i]
        for (int i = 0; i < n; i++) {
            int fi = items[i][0];
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % fi == 0) {
                    cnt++;
                }
            }
            freeCount[i] = cnt;
        }

        int[] dp = new int[budget + 1];

        for (int i = 0; i < n; i++) {
            int price = items[i][1];
            int bonus = freeCount[i];
            if (price > budget) {
                continue;
            }

            // 1. First purchase of item i (0/1 transition: right-to-left)
            for (int b = budget; b >= price; b--) {
                dp[b] = Math.max(dp[b], dp[b - price] + 1 + bonus);
            }

            // 2. Additional copies of item i (unbounded transition: left-to-right)
            for (int b = price; b <= budget; b++) {
                dp[b] = Math.max(dp[b], dp[b - price] + 1);
            }
        }

        return dp[budget];
    }
}