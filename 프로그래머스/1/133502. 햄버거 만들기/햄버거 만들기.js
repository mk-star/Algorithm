function solution(ingredient) {
    let cnt = 0;
    
    for (let i = 0; i < ingredient.length; i++) {
        if (ingredient[i] == 1) {
            const temp = ingredient.slice(i - 3, i + 1);
            if (JSON.stringify(temp) === JSON.stringify([1, 2, 3, 1])) {
                cnt++;
                ingredient.splice(i - 3, 4);
                i -= 4;
            }
        }
    }
    return cnt;
}
