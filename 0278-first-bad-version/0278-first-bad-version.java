/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        
        while (left < right) {
            // Avoids integer overflow compared to (left + right) / 2
            int mid = left + (right - left) / 2;
            
            if (isBadVersion(mid)) {
                // mid might be the first bad version, so keep it in the search space
                right = mid;
            } else {
                // mid is good, so the first bad version must be after mid
                left = mid + 1;
            }
        }
        
        // When left == right, we've narrowed it down to the first bad version
        return left;
    }
}