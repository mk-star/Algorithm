import java.util.Arrays;

class Solution
{
    public int solution(int []A, int []B)
    {
        // 둘 다 정렬
        Arrays.sort(A);
        Arrays.sort(B);
        
        int sum = 0;
        for(int i = 0; i < A.length; i++) {
            sum += A[i] * B[B.length - i - 1];
        }
        
        return sum;
    }
}
// 제일 작은 숫자 순서대로 * 제일 큰 숫자 순서대로