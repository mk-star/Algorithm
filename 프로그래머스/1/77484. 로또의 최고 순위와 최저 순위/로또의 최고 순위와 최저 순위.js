function solution(lottos, win_nums) {
    const rank = [6, 6, 5, 4, 3, 2, 1];
    
    const minCnt = lottos.filter((x) => win_nums.includes(x)).length; // 2
    const zeroCnt = lottos.filter((x) => !x).length; // 2
    
    return [rank[minCnt + zeroCnt], rank[minCnt]];
}