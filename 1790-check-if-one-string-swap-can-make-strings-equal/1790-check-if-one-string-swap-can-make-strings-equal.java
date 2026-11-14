class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int first = -1;
        int second = -1;
        int diffCount = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCount++;
                if (diffCount == 1) {
                    first = i;
                } else if (diffCount == 2) {
                    second = i;
                } else {
                    return false; // More than 2 mismatches
                }
            }
        }

        // Either strings are already equal (0 diffs)
        // or the 2 mismatched characters cross-match
        return diffCount == 0 || 
               (diffCount == 2 && 
                s1.charAt(first) == s2.charAt(second) && 
                s1.charAt(second) == s2.charAt(first));
    }
}