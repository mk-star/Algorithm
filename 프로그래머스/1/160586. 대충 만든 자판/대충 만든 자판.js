function solution(keymap, targets) {
    const result = [];
    const map = {}

    for(const items of keymap) {
        items.split('').map((item, index) => map[item] = map[item] < index + 1 ? map[item] : index + 1)
    }
    
    for(const items of targets) {
        result.push(items.split('').reduce((acc, cur) => acc += map[cur], 0) || -1)
    }
    
    return result;
}