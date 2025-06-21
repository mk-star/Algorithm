function solution(N, stages) {
    let players = stages.length;
    let map = new Map();
    
    for(let i = 1; i <= N; i++) {
        let cnt = 0;
        for(let j = 0; j < stages.length; j++) {
            if(stages[j] === i) {
                cnt++;
            }
        }
        map.set(i, cnt / players);
        players -= cnt;
    }

    let keys = [...map.entries()]
        .sort((a, b) => b[1] - a[1])
        .map(([key]) => key);
    return keys;
}