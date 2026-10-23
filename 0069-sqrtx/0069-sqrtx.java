class Solution {
    public int mySqrt(int x) {
        
        if(x == 0 || x == 1)
            return x;
        
        int low = 1;
        int high = x;
        int ans = 0;
        
        while(low <= high) {
            
            int mid = low + (high - low) / 2;
            
            // use long to avoid overflow
            long square = (long) mid * mid;
            
            if(square == x) {
                return mid;
            }
            else if(square < x) {
                ans = mid;      // possible answer
                low = mid + 1;  // search right
            }
            else {
                high = mid - 1; // search left
            }
        }
        
        return ans;
    }
}