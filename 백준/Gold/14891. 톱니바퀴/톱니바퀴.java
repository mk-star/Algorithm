import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LinkedList<Integer>[] list = new LinkedList[5];
        for(int i = 1; i <= 4; i++) {
            list[i] = new LinkedList<>();
        }

        int idx = 1;
        for(int i = 0; i < 4; i++) {
            String s = br.readLine();
            for(int j = 0; j < 8; j++) {
                list[idx].offer(s.charAt(j) - '0');
            }
            idx++;
        }

        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            boolean[] visited = new boolean[5];
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[] { num, dir });

            while(!queue.isEmpty()) {
                int[] q = queue.poll();
                num = q[0]; dir = q[1];

                LinkedList<Integer> temp = list[num];

                if(num - 1 > 0 && !visited[num - 1]) {
                    if(temp.get(6) != list[num - 1].get(2)) {
                        queue.offer(new int[] { num - 1, dir == -1 ? 1 : -1 });
                    }
                }
                if(num + 1 <= 4 && !visited[num + 1]){
                    if(temp.get(2) != list[num + 1].get(6)) {
                        queue.offer(new int[] { num + 1, dir == -1 ? 1 : -1 });
                    }
                }

                if(dir == -1) {
                    temp.offerLast(temp.pollFirst());
                } else {
                    temp.offerFirst(temp.pollLast());
                }
                
                visited[num] = true;
            }
        }

        int result = 0;
        int score = 1;
        for(int i = 1; i <= 4; i++) {
            if(list[i].get(0) == 1) result += score;
            score *= 2;
        }

        System.out.println(result);
    }
}
