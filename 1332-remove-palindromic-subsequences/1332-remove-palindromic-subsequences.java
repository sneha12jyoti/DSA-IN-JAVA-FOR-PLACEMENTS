class Solution {
    public int removePalindromeSub(String s) {
        // If the string is empty, 0 steps are needed.
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        // Check if the string is already a palindrome.
        // If it is, we can remove it in 1 step.
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // Not a palindrome, so we need at most 2 steps.
                // Step 1: Remove all 'a's (which form a palindrome).
                // Step 2: Remove all 'b's (which also form a palindrome).
                return 2;
            }
            left++;
            right--;
        }
        
        // If it's a palindrome, return 1.
        return 1;
    }
}