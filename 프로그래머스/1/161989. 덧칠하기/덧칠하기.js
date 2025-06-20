function solution(n, m, section) {
    var cnt = 0;
    
    for(let i = 1; i <= n; i++) {
        if(section.includes(i)) {
            cnt++;
            i += m - 1;
        }
    }
    return cnt;
}