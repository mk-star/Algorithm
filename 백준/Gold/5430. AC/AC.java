import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            str = str.replace("[", "");
            str = str.replace("]", "");
            
            Deque<Integer> dq = new ArrayDeque<>();
            if(n != 0) {
                for(String s : str.split(",")) {
                    dq.offer(Integer.parseInt(s));
                }
            }

            int rCnt = 0;
            boolean isErr = false;
            for(String s : p.split("")) {
                if(s.equals("R")) rCnt++;
                if(s.equals("D")) {
                    if(dq.size() == 0) {
                        isErr = true;
                        break;
                    }
                    if(rCnt % 2 == 0) {
                        dq.pollFirst();
                    } else {
                        dq.pollLast();
                    }
                }
            }

            if(isErr) {
                System.out.println("error");   
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                if(rCnt % 2 == 0) {
                    while(!dq.isEmpty()) {
                        sb.append(dq.pollFirst()).append(",");
                    }
                } else {
                    while(!dq.isEmpty()) {
                        sb.append(dq.pollLast()).append(",");
                    }
                }
                if(sb.length() != 1) sb.deleteCharAt(sb.length() - 1);
                sb.append("]");
                System.out.println(sb);
            }
        }
    }
}