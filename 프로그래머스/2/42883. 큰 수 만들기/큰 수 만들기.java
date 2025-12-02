import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        
        for(char c : number.toCharArray()) {
            while(!stack.isEmpty() && stack.peek() < c && k > 0) {
                stack.pop();
                k--;
            }
            
            stack.push(c);
        }
        
        // k가 남아있으면 뒤에서 제거
        while (k-- > 0) stack.pop();
        
        StringBuilder sb = new StringBuilder();
        for(char c : stack) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}
