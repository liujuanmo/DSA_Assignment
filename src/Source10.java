import java.util.*;

public class Source10 {

    public static int median(int[] arr1, int[] arr2 , int n){

        // Write code here
        // 合并两个已排序的数组
        int[] mergedArr = new int[2 * n];
        int i = 0, j = 0, k = 0;
        while (i < n && j < n) {
            if (arr1[i] < arr2[j]) {
                mergedArr[k] = arr1[i++];
                k++;
            } else {
                mergedArr[k] = arr2[j++];
                k++;
            }
        }

        while (i < n) {
            mergedArr[k++] = arr1[i++];
        }

        while (j < n) {
            mergedArr[k++] = arr2[j++];
        }

        // 计算中位数
        if (k % 2 == 0) {
            // 如果数组长度为偶数，则中位数为中间两个数的平均值
            return (mergedArr[k / 2 - 1] + mergedArr[k / 2]) / 2;
        } else {
            // 如果数组长度为奇数，则中位数为中间的数
            return mergedArr[k / 2];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr1[] = new int[n];
        int arr2[] = new int[n];

        for(int i = 0 ; i < n ; i++){
            arr1[i] = sc.nextInt();
        }

        for(int i = 0 ; i < n ; i++){
            arr2[i] = sc.nextInt();
        }
        System.out.println(median(arr1, arr2, n));
    }
}