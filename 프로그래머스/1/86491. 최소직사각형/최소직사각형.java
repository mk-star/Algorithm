class Solution {
    public int solution(int[][] sizes) {
        int width = 0;
        int height = 0;

        for(int i = 0; i < sizes.length; i++) {
            // 각 명함 가로, 세로의 대소 비교
            int max = Math.max(sizes[i][0], sizes[i][1]);
            int min = Math.min(sizes[i][0], sizes[i][1]);

            // 큰 값 중에 가장 큰 것
            width = Math.max(width, max);
            // 작은 값 중에 가장 큰 것
            height = Math.max(height, min);
        }
        return width * height;
    }
}