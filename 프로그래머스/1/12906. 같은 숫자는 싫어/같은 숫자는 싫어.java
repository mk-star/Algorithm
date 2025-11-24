import java.util.*;
// 숫자 0~9로 이뤄진 배열
// 배열에서 연속적으로 나타나는 숫자는 1개만 남기고 전부 제거
// [1, 1, 3, 3, 0, 1, 1] -> [1, 3, 0, 1] 을 return
// 가장 최근에 들어온 값이 현재 값과 같다면 (연속이라면) continue, 다르다면 push

public class Solution {
    public int[] solution(int[] arr) {        
        Stack<Integer> stack = new Stack<>();
        
        stack.push(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            if(stack.peek() != arr[i]) stack.push(arr[i]);
        }
        
        int[] answer = new int[stack.size()];
        int idx = stack.size() - 1;
        while(!stack.isEmpty()) {
            answer[idx--] = stack.pop();
        }

        return answer;
    }
}