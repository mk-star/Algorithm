// 3 3 2 2 1 1 1
function solution(k, m, score) {
    let result = 0;
    const arr = score.sort((a, b) => b - a)
                    .filter((_, index) => (index + 1) % m == 0);
    
    for(let i = 0; i < arr.length; i++) {
        result += arr[i] * m;
    }
    return result;
}
// 점수: 1 ~ k
// m개를 뽑음 -> 내림차순 정렬해서 앞에서부터 m개 뽑음
// 가격: p(뽑은 m개 중 가장 마지막 요소)*m, 
// 이익: 가격의 총합