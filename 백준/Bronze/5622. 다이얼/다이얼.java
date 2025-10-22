import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int num = 0;
        int sum = 0;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if(c >= 'A' && c <='C') {
                num = 2;
            } else if(c >= 'D' && c <='F') {
                num = 3;
            } else if(c >= 'G' && c <='I') {
                num = 4;
            } else if(c >= 'J' && c <='L') {
                num = 5;
            } else if(c >= 'M' && c <= 'O') {
                num = 6;
            } else if(c >= 'P' && c <= 'S') {
                num = 7;
            } else if(c >= 'T' && c <= 'V') {
                num = 8;
            } else {
                num = 9;
            }
            
            sum += num - 1 + 2;
        }

        System.out.println(sum);
    }
}
