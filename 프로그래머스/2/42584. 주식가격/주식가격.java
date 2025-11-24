import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            // 현재 가격이 스택의 top에 있는 인덱스의 가격보다 작으면 (가격이 떨어지면)
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                // 현재 인덱스와 스택에서 꺼낸 인덱스의 차이
                answer[stack.peek()] = i - stack.pop();
            }

            // 현재 인덱스를 스택에 push
            stack.push(i);
        }
     
        // 끝까지 가격이 떨어지지 않음
        while(!stack.isEmpty()) {
            int idx = stack.pop();
            
            // 배열의 마지막 인덱스와 스택에서 꺼낸 인덱스의 차이
            answer[idx] = len - 1 - idx;
        }

        return answer;
    }
}
