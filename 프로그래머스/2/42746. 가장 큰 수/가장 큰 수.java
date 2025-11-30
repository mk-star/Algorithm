import java.util.*;

class Solution { 
    public String solution(int[] numbers) {
        
        String[] str = new String[numbers.length];
            
        for(int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        
        // 30, 3일 때 303과 330를 비교, 내림차순 정렬
        Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));
        
        StringBuilder sb = new StringBuilder();
        int zeroCnt = 0;
        for(String s : str) {
            sb.append(s);
            if(s.equals("0")) zeroCnt++;
        }
        
        if(zeroCnt == sb.length()) return "0";
        else return sb.toString();
    
    }
}