import java.util.*;
class Solution {
    public int solution(int[] citations) {  
        Arrays.sort(citations);

        int answer = 0;
        int N = citations.length;
        for(int i = 0; i < N; i++) {
            int index = N - i;
            if (citations[i] >= index) {
                answer = index;
                break;
            }
        }
        return answer;
    }
}