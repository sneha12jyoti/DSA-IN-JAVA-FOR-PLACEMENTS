import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length();
        // prefix[i] stores the bitmask of character frequencies for s[0 ... i-1]
        int[] prefix = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            int bit = 1 << (s.charAt(i) - 'a');
            prefix[i + 1] = prefix[i] ^ bit;
        }
        
        List<Boolean> result = new ArrayList<>(queries.length);
        
        for (int[] q : queries) {
            int left = q[0];
            int right = q[1];
            int k = q[2];
            
            // XOR range query to get the bitmask of characters in s[left ... right]
            int mask = prefix[right + 1] ^ prefix[left];
            
            // Count how many characters appear an odd number of times
            int oddCount = Integer.bitCount(mask);
            
            // Each replacement can fix up to 2 odd frequencies
            // So we need at most oddCount / 2 replacements
            result.add(oddCount / 2 <= k);
        }
        
        return result;
    }
}