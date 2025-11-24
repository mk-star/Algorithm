import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        
        // 0번째 트럭 빼고 bridge_length - 1 만큼
        for(int i = 0; i < bridge_length - 1; i++) {
            queue.offer(0);
        }
        
        // 0번째 트럭을 처음으로 올림
        int current_weight = truck_weights[0];
        queue.offer(current_weight);
        
        int answer = 1; // 0번째 트럭 올라감
        int idx = 1; // 0번째 이후부터
        
        while(!queue.isEmpty()) {
            // 맨 앞 트럭 or 0 무게 제거
            int temp = queue.poll();
            answer++;
            current_weight -= temp;
            
            // 올라가야 할 트럭이 있는 경우
            if(idx < truck_weights.length) {
                // 현재 다리에 있는 트럭 무게 + 다음에 올라올 트럭 무게 <= 최대 무게
                if(current_weight + truck_weights[idx] <= weight) {
                    current_weight += truck_weights[idx];
                    //다음 트럭 추가
                    queue.offer(truck_weights[idx]);
                    idx++;
                } else {
                    // 트럭이 못 올라옴
                    queue.offer(0);
                }
            }
        }
        
        return answer;
    }
}

// - -