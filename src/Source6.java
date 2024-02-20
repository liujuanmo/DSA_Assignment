import java.util.*;

public class Source6 {

    public static void symmetricPair(int[][] arr) {
        // Write code here
        HashMap<Integer, Integer> h = new HashMap<>();
        h.put(arr[0][0], arr[0][1]);
        for (int i = 1; i < arr.length; i++) {
            int first1 = arr[i][0];
            int second1 = arr[i][1];
            Integer data = h.get(second1);
            //如果h.containskey(second1)返回的值是真的，即key second1对应的值非空，
            // 对比key second1对应的值是否等于first1，如果等于，则为对称对，打印先推入哈希图中的数组。
            if (data != null && data == first1) {
                //int data=h.get(second1);
                System.out.println(second1 + " " + first1);
            }
            else {
                h.put(first1,second1);
            }
        }
    }

        public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int arr[][] = new int[row][2];
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < 2 ; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        //System.out.println(arr);
        symmetricPair(arr);
    }
}