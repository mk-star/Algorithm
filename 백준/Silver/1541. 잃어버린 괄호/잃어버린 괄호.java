import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        String[] calc = s.split("-");
        int min = 0;
        for(int i = 0; i < calc.length; i++) {
            String[] num = calc[i].split("\\+");
            int sum = 0;
            for(int j = 0; j < num.length; j++) {
                sum += Integer.parseInt(num[j]);
            }
            if(i != 0) sum = - sum;
            min += sum;
        }
        System.out.println(min);
    }
}