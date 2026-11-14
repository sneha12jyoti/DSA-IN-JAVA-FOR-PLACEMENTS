import java.util.Arrays;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        // Sort arr2 to enable binary search
        Arrays.sort(arr2);
        int farCount = 0;

        for (int num : arr1) {
            if (isFar(num, arr2, d)) {
                farCount++;
            }
        }

        return farCount;
    }

    // Checks if no element in arr2 lies within [target - d, target + d]
    private boolean isFar(int target, int[] arr2, int d) {
        int left = 0;
        int right = arr2.length - 1;
        int minAllowed = target - d;
        int maxAllowed = target + d;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If arr2[mid] falls inside the forbidden range, target is NOT far
            if (arr2[mid] >= minAllowed && arr2[mid] <= maxAllowed) {
                return false;
            } else if (arr2[mid] < minAllowed) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return true;
    }
}