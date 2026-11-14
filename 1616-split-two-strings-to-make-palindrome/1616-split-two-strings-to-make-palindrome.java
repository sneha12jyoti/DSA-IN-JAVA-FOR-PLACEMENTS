class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }

    // Checks if a_prefix + b_suffix can form a palindrome
    private boolean check(String a, String b) {
        int left = 0;
        int right = a.length() - 1;

        // Match characters from the outside moving inward
        while (left < right && a.charAt(left) == b.charAt(right)) {
            left++;
            right--;
        }

        // Once a mismatch occurs, the remaining middle part of either string must be a palindrome
        return isPalindrome(a, left, right) || isPalindrome(b, left, right);
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}