import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int jimin = Integer.parseInt(st.nextToken());
        int hansu = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        for(int i = 1; i <= N; i++) {
            list.add(i);
        }
        
        int cnt = 0;
        boolean isFight = false;
        while(list.size() > 1) {
            int len = list.size();
            for(int i = 1; i <= len / 2; i++) {
                if(list.get(i) == jimin || list.get(i) == hansu) {
                    if(list.get(i) == jimin && list.get(i - 1) == hansu ||
                        list.get(i) == hansu && list.get(i - 1) == jimin) {
                        isFight = true;
                        break;
                    }
                    list.remove(i - 1);
                } else {
                    list.remove(i);
                }
            }

            cnt++;
            if(isFight) break;
        }
        System.out.println(isFight ? cnt : -1);

	}
}