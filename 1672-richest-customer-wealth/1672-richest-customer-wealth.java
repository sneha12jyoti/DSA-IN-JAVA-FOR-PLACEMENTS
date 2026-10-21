class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxwealth=0;
        for(int customer[]:accounts){
            int currentwealth=0;
            for(int bank:customer){
                currentwealth+=bank;
            }
            maxwealth=Math.max(maxwealth,currentwealth);
        }
        return maxwealth;
    }
}