
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        List<Integer> arr = new ArrayList<>();

        for(int i = 1; i <= N; i++)
            arr.add(i);

        StringBuilder result = new StringBuilder();
        result.append("<");
       
        int index = 0;
        while(!arr.isEmpty()) {
            index = (index + K - 1) % arr.size();
            result.append(arr.remove(index));
            if(arr.size() != 0)
                result.append(", ");
        }
        result.append(">");
        System.out.println(result);
    }
}
