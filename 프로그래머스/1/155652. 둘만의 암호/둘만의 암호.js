function solution(s, skip, index) {
    var answer = "";
    for(let i = 0; i < s.length; i++) {
        let c = s.charAt(i);
        var ascii = c.charCodeAt(0); // 115
        var cnt = 0;
        while(cnt < index) {
            ascii++;
            if(ascii > 122) ascii = 97;
            if(!skip.includes(String.fromCodePoint(ascii))) cnt++;
        }
        answer += String.fromCodePoint(ascii);
    }
    return answer;
}

