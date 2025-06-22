function solution(keymap, targets) {
    let result = [];
    
    for(let i = 0; i < targets.length; i++) {
        let cnt = 0;
        targets[i].split("").some((x) => {
            let minIndex = 999;
            for(let j = 0; j < keymap.length; j++) {
                keymap[j].split("").map((y, index) => {
                    if(x === y) minIndex = Math.min(minIndex, index + 1);
                })
            }
            if(minIndex === 999) {
                result.push(-1);
                cnt = 0;
                return true;
            }
            cnt += minIndex;
        })
        if(cnt !== 0) result.push(cnt);
    }
    return result;
}