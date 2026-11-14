class Solution {
    public int countSubstrings(String s) {
        int totalCount = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Count odd-length palindromes (single character center)
            totalCount += expandAroundCenter(s, i, i);
            
            // Count even-length palindromes (two-character center)
            totalCount += expandAroundCenter(s, i, i + 1);
        }
        
        return totalCount;
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        int count = 0;
        
        // Expand outward as long as pointers are in bounds and characters match
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        
        return count;
    }
}