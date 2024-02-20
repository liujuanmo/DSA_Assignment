import java.util.*;

public class Source9 {

    public static int search(int arr[], int left, int right, int key) {
        // Write code here
        int result=-1;
        for(int j=0;j<arr.length;j++){
            if(key==arr[j]){
                result=j;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        int key = sc.nextInt();
        int i = search(arr, 0, n - 1, key);
        if (i != -1) {
            System.out.println(i);
        } else {
            System.out.println("-1");
        }
    }
}