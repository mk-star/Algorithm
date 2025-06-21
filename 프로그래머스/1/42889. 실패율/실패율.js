function solution(N, stages) {
    let result = [];
    
    for(let i = 1; i <= N; i++) {
        let reach = stages.filter((x) => x >= i).length;
        let curr = stages.filter((x) => x === i).length;
        
        result.push([i, curr / reach]); // 배열을 push -> 2차원 배열
    }
    
    result.sort((a, b) => b[1] - a[1]); // 두 번째 원소를 기준으로 정렬
    return result.map((x) => x[0]);
}