
import java.util.*;

class MedianFinder {

    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    public MedianFinder() {
        // Max heap for the smaller half
        small = new PriorityQueue<>(Collections.reverseOrder());

        // Min heap for the larger half
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {

        // Add the number to the appropriate heap
        if (small.isEmpty() || num <= small.peek()) {
            small.offer(num);
        } else {
            large.offer(num);
        }

        // Balance the heaps
        if (small.size() > large.size() + 1) {
            large.offer(small.poll());
        } else if (large.size() > small.size() + 1) {
            small.offer(large.poll());
        }
    }

    public double findMedian() {

        if (small.size() == large.size()) {
            return ((double) small.peek() + large.peek()) / 2.0;
        }

        if (small.size() > large.size()) {
            return small.peek();
        }

        return large.peek();
    }

    public static void main(String[] args) {

        MedianFinder mf = new MedianFinder();

        mf.addNum(1);
        System.out.println(mf.findMedian()); // 1.0

        mf.addNum(2);
        System.out.println(mf.findMedian()); // 1.5

        mf.addNum(3);
        System.out.println(mf.findMedian()); // 2.0

        mf.addNum(4);
        System.out.println(mf.findMedian()); // 2.5

        mf.addNum(5);
        System.out.println(mf.findMedian()); // 3.0
    }
}

