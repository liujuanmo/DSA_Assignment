import java.util.*;

public class Source8 {

    public static void findItinerary(Map<String, String> tickets) {
        // Write code here
        String startingPoint = null;
        for (Map.Entry<String, String> entry : tickets.entrySet()) {
            if (!tickets.containsValue(entry.getKey())) {
                startingPoint = entry.getKey();
                break;
            }
        }
        String temp = startingPoint;
        //System.out.print(temp );
        while (temp != null&&tickets.get(temp)!=null) {
            System.out.println( temp+"->"+tickets.get(temp));
            temp = tickets.get(temp);
        }

    }

    public static void main(String[] args) {
        Map<String, String> tickets = new HashMap<String, String>();
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            tickets.put(sc.next(),sc.next());
        }
        findItinerary(tickets);
    }
}