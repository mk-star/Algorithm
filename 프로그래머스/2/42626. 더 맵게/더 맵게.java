import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville) {
            pq.offer(s);
        }
        
        int cnt = 0;
        while(true) {
            if(pq.peek() >= K) return cnt;
            
            if(pq.size() < 2) break;
            
            int num = pq.poll() + pq.poll() * 2;
            
            pq.offer(num);
            cnt++;
        }
        return -1;
    }
}