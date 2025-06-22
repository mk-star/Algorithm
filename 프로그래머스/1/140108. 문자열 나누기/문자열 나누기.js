function solution(s) {
    let result = "";
    let xCnt = 0, oCnt = 0;
    let x = s[0];
    let start = 0, end = 0;
    
    for(let i = 0; i < s.length; i++) {
        if(x === s.charAt(i)) xCnt++;
        else oCnt++;
        
        if(xCnt === oCnt) {
            end = i + 1;
            result += s.slice(start, end);
            if(end !== s.length) {
                result += '-';
            }
            start = end;
            xCnt = 0, oCnt = 0;
            x = s[i + 1];
        }
    }
    return result.split('-').length;
}