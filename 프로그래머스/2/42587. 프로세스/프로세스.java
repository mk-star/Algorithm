import java.util.*;

// 큐에서 프로세스를 하나 꺼내는데, 
// 이 프로세스의 우선순위가 가장 높으면 실행 (다시 큐에 넣지 않음)
// 아니면 다시 큐에 넣기

// [A, B, C, D] [2, 1, 3, 2]
// 1. A를 뽑았는데 우선순위가 2, 다시 큐에 넣는다 -> [B, C, D, A]
// 2. B를 뽑았는데 우선순위가 1, 다시 큐에 넣는다 -> [C, D, A, B]
// 3. C를 뽑음 -> [D, A, B];
// 4. D를 뽑음 -> [A, B]
// 5. A를 뽑음 -> [B]
// 6. B를 뽑음
// C, D, A, B 순

// location에 위치한 프로세스가 몇 번째에 실행되는지를 구하는 문제니까
// 프로세스의 index랑 우선순위를 같이 저장하는 클래스를 만듦
// 우선순위를 내림차순으로 정렬해서 비교

class Process {
    int idx;
    int priority;
    
    Process(int idx, int priority) {
        this.idx = idx;
        this.priority = priority;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Process> queue = new LinkedList<>();     
        for(int i = 0; i < priorities.length; i++) {
            queue.offer(new Process(i, priorities[i]));
        }
        
        // 우선순위가 가장 높은 것부터 탐색
        Arrays.sort(priorities);
        
        int idx = priorities.length - 1;
        int cnt = 1;
        while(!queue.isEmpty()) {
            Process p = queue.poll();
    
            if(priorities[idx] == p.priority) {
                // 우선순위가 가장 높은 프로세스라면
                // 우리가 찾고자 하는 location과 같은지 확인
                if(p.idx == location) {
                    // 몇 번째인지 반환
                    answer = cnt;
                    break;
                }
            
                // 다음 우선순위를 탐색
                idx--;
                cnt++;
            } else {
                // 우선순위가 가장 높은 프로세스가 아니라면 다시 큐에 추가
                queue.offer(p);
            }
        }
        
        
        return answer;
    }
}