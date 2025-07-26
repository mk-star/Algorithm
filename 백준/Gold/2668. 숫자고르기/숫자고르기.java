import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static ArrayList<Integer> list;

    static void dfs(int start, int target) {
        if(!visited[arr[start]]) {
            visited[arr[start]] = true;
            dfs(arr[start], target);
            visited[arr[start]] = false;
        }

        if(arr[start] == target) list.add(target);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        visited = new boolean[N + 1];
        list = new ArrayList<>();

        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(int n : list) {
            System.out.println(n);
        }
    }
}