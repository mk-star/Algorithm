function solution(X, Y) {
    let partner = [];
    
    for(let i = 0; i < 10; i++) {
        const XLen = X.split("").filter(s => Number(s) === i).length
        const YLen = Y.split("").filter(s => Number(s) === i).length
        
        for(let j = 0; j < Math.min(XLen, YLen); j++) {
            partner.push(i)
        }
    }
    
    if(partner.length === 0) return "-1"
    
    partner.sort((a, b) => b - a)
    if(partner[0] === 0) {
        return "0";
    } else {
        return partner.join('')
    }
}