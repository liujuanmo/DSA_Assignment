import java.util.*;

public class Source4 {

    private static void sortArray(int[] arr, int k) {
        // 创建一个大小为k的最小堆，按升序排列
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 将数组的前k个元素加入堆中
        for (int i = 0; i <= k && i < arr.length; i++) {
            minHeap.offer(arr[i]);
        }

        // 从第k+1个元素开始遍历数组
        for (int i = k + 1; i < arr.length; i++) {
            // 将堆顶元素（最小元素）加入结果数组中
            arr[i - k - 1] = minHeap.poll();
            // 将当前位置的元素加入堆中
            minHeap.offer(arr[i]);
        }

        // 将堆中剩余的元素依次加入结果数组中
        for (int i = arr.length - k - 1; i < arr.length; i++) {
            arr[i] = minHeap.poll();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 数组的大小
        int k = sc.nextInt(); // 每个元素可以偏离目标位置的最大步数
        int[] arr = new int[n]; // 数组
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt(); // 读取数组元素
        }

        sortArray(arr, k); // 对数组进行排序

        // 输出排序后的数组
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
