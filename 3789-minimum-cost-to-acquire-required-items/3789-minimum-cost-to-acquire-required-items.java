class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        // Use long to prevent integer overflow since costs can be up to 10^6 and needs up to 10^9
        long c1 = cost1;
        long c2 = cost2;
        long cBoth = costBoth;
        long n1 = need1;
        long n2 = need2;

        // 1. Cover the overlapping needs (both type 1 and type 2)
        long common = Math.min(n1, n2);
        long totalCost = common * Math.min(cBoth, c1 + c2);

        // 2. Cover the remaining requirement (only one of these will be > 0)
        long rem1 = n1 - common;
        long rem2 = n2 - common;

        totalCost += rem1 * Math.min(cBoth, c1);
        totalCost += rem2 * Math.min(cBoth, c2);

        return totalCost;
    }
}