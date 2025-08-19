import java.util.*;
// 1 2 4 5 6
class Solution {
    public boolean binarySearch(int[] citations, int h) {
        int left = 0;
        int right = citations.length - 1;
        
        int idx = 0;
        while(left <= right) {
            int mid = (left + right) / 2;
            
            if(citations[mid] < h) {
                left = mid + 1;
            } else {
                right = mid - 1;
                idx = mid;
            }
        }

        if(citations.length - idx >= h) return true;
        else return false;
    }
    
    public int solution(int[] citations) {  
        Arrays.sort(citations);
        int max = citations[citations.length - 1];
        
        int answer = 0;
        for(int i = max; i >= 0; i--) {
            if(binarySearch(citations, i)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}