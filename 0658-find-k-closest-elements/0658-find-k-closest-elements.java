
import java.util.*;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        PriorityQueue<int[]> maxheap = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(b[0], a[0]);
                }
                return Integer.compare(b[1], a[1]);
            }
        );

        for (int num : arr) {
            int diff = Math.abs(num - x);

            maxheap.offer(new int[]{diff, num});

            if (maxheap.size() > k) {
                maxheap.poll();
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!maxheap.isEmpty()) {
            result.add(maxheap.poll()[1]);
        }

        Collections.sort(result);

        return result;
    }
}
