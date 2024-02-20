import java.util.*;

public class Source2 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int k = sc.nextInt();

        int stream[] = new int[n];

        for (int i = 0; i < n; i++) {

            stream[i] = sc.nextInt();

        }



// Write code here
        Stack < Integer > stack = new Stack < Integer > ();
        for (int i = 0; i < n; i++) {
            stack.add( stream[i]);

        }
        System.out.print("原始数据 ：");
        System.out.println(stack);

        //将元素排序后入栈
        List<Integer> list = new ArrayList<>(stack);
        Collections.sort(list);
        stack.clear();
        stack.addAll(list);
        System.out.print("排序后数据 ：");
        System.out.println(stack);

        //寻找第K大元素
        if(k>=2) {
            for (int i = 1; i <= k - 1; i++) {
                stack.pop();
            }
            System.out.println(k+" largest number is "+stack.pop());
        }
        else {
            System.out.println(k+" largest number is "+stack.pop());
        }


    }
}