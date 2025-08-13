import java.io.*;
import java.util.*;

public class Main {
    static boolean[] prime;
    
    static void isPrime(int n) { 
        prime = new boolean[n + 1];
        
        for(int i = 0; i < prime.length; i++){
            prime[i] = true;
        }
        
        prime[0] = prime[1] = false;

        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(prime[i]) {
                for(int j = i * i; j <= n; j += i) {
                    prime[j] = false; // 소수가 아님
                }
            }
        }
    }

	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	

        ArrayList<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            
            list.add(n);
            max = Math.max(n, max);
        }

        isPrime(max);

        for(int i = 0; i < list.size(); i++) {
            int n = list.get(i);
            for(int j = 2; j <= list.get(i); j++) {
                if(prime[j] && prime[n - j]) {
                    System.out.println(n + " = " + j + " + " + (n - j));
                    break;
                }
                if(j == n) {
                    System.out.println("Goldbach's conjecture is wrong.");
                }
            }
        }
	}
}