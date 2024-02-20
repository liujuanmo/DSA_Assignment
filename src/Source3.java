import java.util.*;

public class Source3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] stream = new int[n];
        for (int i = 0; i < n; i++) {
            stream[i] = sc.nextInt();
        }

        KthLargest kthLargest = new KthLargest(k);
        for (int i = 0; i < n; i++) {
            int kth = kthLargest.add(stream[i]);
            if (kth != Integer.MIN_VALUE) {
            } else {
                System.out.println("None");
            }
        }
    }
}

class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k) {
        this.k = k;
        minHeap = new PriorityQueue<>(k);
        System.out.println("KthLargest"+minHeap);
    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.size() < k ? Integer.MIN_VALUE : minHeap.peek();
    }
}
