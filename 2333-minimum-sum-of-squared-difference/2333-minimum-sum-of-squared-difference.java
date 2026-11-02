import java.util.*;

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {

        int n = nums1.length;
        long k = (long) k1 + k2;

        long[] diff = new long[n];

        long max = 0;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs((long) nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
            sum += diff[i];
        }

        if (sum <= k) return 0;

        long low = 0, high = max;

        while (low < high) {

            long mid = low + (high - low) / 2;

            long operations = 0;

            for (long d : diff) {
                if (d > mid) {
                    operations += d - mid;
                }
            }

            if (operations <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        long ans = 0;

        for (long d : diff) {
            long reduced = Math.min(d, low);
            ans += reduced * reduced;
        }

        long remaining = k;

        for (long d : diff) {
            if (d > low) {
                remaining -= d - low;
            }
        }

        // Distribute remaining operations optimally
        for (long d : diff) {
            if (remaining > 0 && d >= low) {
                ans -= low * low - (low - 1) * (low - 1);
                remaining--;
            }
        }

        return ans;
    }
}