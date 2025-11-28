class Solution {
    // 세로는 최소 3, 가로는 최대 (brown + yellow) / 3
    
    public int[] solution(int brown, int yellow) {
        int rc = brown + yellow;
        for(int i = rc / 3; i >= 0 ; i--) {
            if(rc % i == 0) {
                int x = i; // 가로 길이
                int y = rc / i; // 세로 길이
                
                int edge = (x + y) * 2 - 4; // (가로 + 세로) * 2 - 겹친면
                if(brown == edge)
                    return new int [] { x , y };
            }   
        }
        return null;
    }
}