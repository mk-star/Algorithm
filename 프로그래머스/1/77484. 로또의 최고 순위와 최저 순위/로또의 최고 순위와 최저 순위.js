function solution(lottos, win_nums) {
    let correct = 0;
    let zero = 0;
    
    for(let i = 0; i < lottos.length; i++) {
        if(lottos[i] === 0) {
            zero++;
            continue;
        }
        win_nums.map((x) => {
            if(lottos[i] === x) correct++;
        })
    }
    
    const max = correct + zero !== 0 ? 7 - (correct + zero) : 6;
    const min = correct !== 0 ? 7 - correct : 6;
    return [max, min];
}