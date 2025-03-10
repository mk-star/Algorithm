import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> height = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i < 9; i++) {
            height.add(Integer.parseInt(br.readLine()));
            sum += height.get(i);
        }
   
        for(int i = 0; i < 8; i++) {
            for(int j = i + 1; j < 9; j++) {
                if(sum - height.get(i) - height.get(j) == 100) {
                    height.remove(j);
                    height.remove(i);
                    break;
                }
            }
            if(height.size() == 7) break;
        }

        Collections.sort(height);

        for(int i = 0; i < 7; i++) System.out.println(height.get(i));
    }
}
