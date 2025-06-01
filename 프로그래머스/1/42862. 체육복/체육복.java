import java.util.Arrays;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        int count = n - lost.length;
        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    reserve[j] = -1; 
                    lost[i] = -1;
                    count++;
                    break;
                }
            }
        }
        
        for(int i = 0; i < lost.length; i++) {
            if(lost[i] == -1) continue;
            for(int j = 0; j < reserve.length; j++) {
                if(reserve[j] == lost[i] - 1 || reserve[j] == lost[i] + 1) {
                    reserve[j] = -1; 
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}