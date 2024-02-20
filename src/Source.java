import java.util.*;

public class Source {

    public static int mostFrequentElement(int[] arr) {

        // Write code here
        HashMap<Integer,Integer>elementMostFrequentMap=new HashMap<>();
        for(int i=0;i< arr.length;i++){
            if(elementMostFrequentMap.containsKey(arr[i])){
                elementMostFrequentMap.put((arr[i]),elementMostFrequentMap.get(arr[i])+1);
            }
            else elementMostFrequentMap.put(arr[i],1);
        }
        //System.out.print("\n"+elementMostFrequentMap);
        Set<Map.Entry<Integer,Integer>>entrySet=elementMostFrequentMap.entrySet();
        int maxFrequentElement=0;
        int maxCount=0;
        for(Map.Entry<Integer,Integer>entry:entrySet){
            if(entry.getValue()>maxCount){
                maxCount=entry.getValue();
                maxFrequentElement=entry.getKey();
                //System.out.println(maxCount+" "+maxFrequentElement);
            }
        }

        return maxFrequentElement;
    }


    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(mostFrequentElement(arr));
    }
}