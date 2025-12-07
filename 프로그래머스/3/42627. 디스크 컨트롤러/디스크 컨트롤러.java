import java.util.*;

class Task implements Comparable<Task> {
    int no; // 번호
    int reqTime; // 요청 시각
    int duration; // 소요 시간
    
    Task(int no, int reqTime, int duration) {
        this.no = no;
        this.reqTime = reqTime;
        this.duration = duration;
    }
    
    // 우선순위: 작업의 소요시간이 짧은 것, 작업의 요청 시각이 빠른 것, 작업의 번호가 작은 것 순
    @Override
    public int compareTo(Task t) {
        if(this.duration != t.duration) return this.duration - t.duration;
        if(this.reqTime != t.reqTime) return this.reqTime - t.reqTime; 
        return this.no - t.no;  
    }
}

class Solution {
    public int solution(int[][] jobs) {
        
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
            
        PriorityQueue<Task> pq = new PriorityQueue<>();

        int point = 0; // 시점
        int returnTime = 0; // 반환 시간
        int index = 0; // jobs의 index
        
        while(index < jobs.length || !pq.isEmpty()) {
            // 현재 시점 안에 들어올 수 있는 작업을 삽입
            while(index < jobs.length && jobs[index][0] <= point) {
                pq.offer(new Task(index, jobs[index][0], jobs[index][1]));
                index++;
            }
               
            // 현재 시점에 들어올 작업이 없다면, 가장 먼저 들어오는 작업을 바로 시작
            if(pq.isEmpty()) {
                point = jobs[index][0];
            } else {
                // 처리 중인 작업이 없다면,
                // 현재 시점에서 우선순위가 높은 작업을 처리
                Task t = pq.poll();
                point += t.duration;
                returnTime += point - t.reqTime;
            }
        }
        
        return returnTime / jobs.length;
    }
}