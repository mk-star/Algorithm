import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 1; i <= N; i++) list.add(i);

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int index = 0;
        while(list.size() != 1) {
            index = (index + (K - 1)) % list.size();
            sb.append(list.remove(index)).append(", ");
        }
        sb.append(list.remove()).append(">");

        System.out.println(sb);
    }
}