import java.util.*;
import java.util.TreeSet;

public class Source7 {

    public static void printElementInAllRows(int mat[][]) {

        // Write code here
        // 记录每个元素在矩阵中的出现次数
        Map<Integer, Integer> elementCountMap = new HashMap<>();
        // 记录每个元素在每一行中的出现次数
        Map<Integer, Map<Integer, Integer>> rowElementCountMap = new HashMap<>();

        int row = mat.length;
        int col = mat[0].length;

        // 统计每个元素在矩阵中的出现次数
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int element = mat[i][j];
                elementCountMap.put(element, elementCountMap.getOrDefault(element, 0) + 1);
                // 记录每个元素在每一行中的出现次数
                if (!rowElementCountMap.containsKey(element)) {
                    rowElementCountMap.put(element, new HashMap<>());
                }
                rowElementCountMap.get(element).put(i, rowElementCountMap.get(element).getOrDefault(i, 0) + 1);
            }
        }

        // 打印所有行中存在的公共元素
        Queue<Integer> queue = new LinkedList<>();
        int count=0;
        for (Map.Entry<Integer, Map<Integer, Integer>> entry : rowElementCountMap.entrySet()) {
            int element = entry.getKey();
            Map<Integer, Integer> rowMap = entry.getValue();
            if (rowMap.size() == row) {
                queue.add(element);
                count++;
                //System.out.println(element);
            }
        }
        int[] arr = new int[count];
        for(int i=0;i<count;i++){
            arr[i]= queue.poll();
        }
        // 使用Arrays类中的sort方法对数组A进行升序排序
        Arrays.sort(arr);

        // 打印排序后的数组A
        for (int num : arr) {
            System.out.print(num + " ");
        }

    }

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();

        int matrix[][] = new int[row][col];
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        printElementInAllRows(matrix);
    }
}