import java.util.*;
// 1번 수포자: 1~5 순서대로 찍음
// 2번 수포자: 2 (고정) + 1 ~ 5 반복
// 3번 수포자: 33 -> 11 -> 22 -> 44 -> 55 반복
class Solution {
    public int[] solution(int[] answers) {    
        
        int[] supoja1 = { 1, 2, 3, 4, 5 };
        int[] supoja2 = { 2, 1, 2, 3, 2, 4, 2, 5 }; 
        int[] supoja3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

        // 문제를 채점한다.
        int[] score = new int[3];
        for(int i = 0; i < answers.length; i++) {
            if(supoja1[i % 5] == answers[i]) score[0]++;
            if(supoja2[i % 8] == answers[i]) score[1]++;
            if(supoja3[i % 10] == answers[i]) score[2]++;   
        }
        
        // 가장 높은 점수를 받은 사람이 여럿일 경우 배열로 반환
        int max = Math.max(score[0], Math.max(score[1], score[2]));
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            if(score[i] == max) {
                list.add(i + 1);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}