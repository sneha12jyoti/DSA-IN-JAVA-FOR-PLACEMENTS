class Solution {
    public int maxProfit(int[] prices) {
        int minprice=Integer.MAX_VALUE;
        int maxprofit=0;
        for(int price:prices){
            minprice=Math.min(minprice,price);
            int profit=price-minprice;
            maxprofit=Math.max(maxprofit,profit);
        }
        return maxprofit;
    }
}