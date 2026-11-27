class Solution {
    public boolean canAliceWin(int n) {
        int stonesToRemove = 10;
        boolean aliceTurn = true;
        
        while (n >= stonesToRemove) {
            n -= stonesToRemove;
            stonesToRemove--;
            aliceTurn = !aliceTurn;
        }
        
        // The player whose turn it is when n < stonesToRemove cannot move and loses,
        // meaning the previous player won.
        return !aliceTurn;
    }
}