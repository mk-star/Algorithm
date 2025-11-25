import java.util.*;
// 1번 수포자: 1~5 순서대로 찍음
// 2번 수포자: 2 (고정) + 1 ~ 5 반복
// 3번 수포자: 33 -> 11 -> 22 -> 44 -> 55 반복
class Solution {
    public int[] solution(int[] answers) {    
        int len = answers.length;
        int[] supoja1 = new int[len];
        int[] supoja2 = new int[len];
        int[] supoja3 = new int[len];
        
        // 1번 수포자가 찍는 방식
        int num = 1;
        for(int i = 0; i < answers.length; i++) {
            supoja1[i] = num++;
            if(num == 6) num = 1;
        }
        
        // 2번 수포자가 찍는 방식        
        num = 1;
        for(int i = 0; i < answers.length; i++) {
            if(i % 2 == 0) supoja2[i] = 2;
            else supoja2[i] = num++;
            if(num == 6) num = 1;
            if(num == 2) num++;
        }
        
        // 3번 수포자가 찍는 방식
        int[] temp = { 3, 1, 2, 4, 5 };
        int idx = 0;
        for(int i = 0; i < answers.length; i++) {
            supoja3[i] = temp[idx];
            if(i % 2 == 1) idx++;
            if(idx == 5) idx = 0;
        }
        
        for(int n : supoja3) {
            System.out.print(n);
        }
        // 문제를 채점한다.
        int[] cnt = new int[3];
        for(int i = 0; i < answers.length; i++) {
            if(supoja1[i] == answers[i]) cnt[0]++;
            if(supoja2[i] == answers[i]) cnt[1]++;
            if(supoja3[i] == answers[i]) cnt[2]++;   
        }
        
        // 가장 높은 점수를 받은 사람이 여럿일 경우 배열로 반환
        List<Integer> list = new ArrayList<>();
        
        int max = cnt[0]; 
        max = Math.max(max, Math.max(cnt[1], cnt[2]));
             
        for(int i = 0; i < 3; i++) {
            if(cnt[i] == max) {
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