import java.io.*;
import java.util.*;

// 좌표 클래스
class Point {
    int x;
    int y;
 
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
 
public class Main {
    static int N, M;
    static ArrayList<Point> home, chicken;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    static void dfs(int index, int depth) {
        if(depth == M) { // M개 뽑았을 때,
            int[] minDist = new int[home.size()]; // 치킨집과 집 사이의 최소 거리

            for(int i = 0; i < chicken.size(); i++) {
                if(visited[i]) {
                    // 뽑은 치킨집과 집 사이의 거리를 구함.
                    for(int j = 0; j < home.size(); j++) { // 모든 집을 돌면서 i번째 치킨집과의 거리를 구함
                        int dist = Math.abs(home.get(j).x - chicken.get(i).x) + Math.abs(home.get(j).y - chicken.get(i).y);

                        if(minDist[j] == 0) minDist[j] = dist;
                        else minDist[j] = Math.min(dist, minDist[j]);
                    }
                }
            }

            int sum = 0;
            for(int i = 0; i < home.size(); i++) {
                sum += minDist[i];
            }
            min = Math.min(sum, min);
            return;
        }

        for(int i = index; i < chicken.size(); i++) {
            if(!visited[i]) {
                visited[i] = true; // i번째 치킨집 방문
                dfs(i + 1, depth + 1);
                visited[i] = false; // i번째 치킨집 방문 X
            }
        }
    }
    
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        chicken = new ArrayList<>(); // 치킨집 좌표
        home = new ArrayList<>(); // 집 좌표

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int type = Integer.parseInt(st.nextToken());
                if (type == 1) { // 집일 경우
                    home.add(new Point(i, j));
                } else if (type == 2) { // 치킨집일 경우
                    chicken.add(new Point(i, j));
                }
            }
        }

        visited = new boolean[chicken.size()];
        dfs(0, 0);
        System.out.println(min);
	}
}